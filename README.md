E Compiler
============

# Description
The *E compiler* is computer software that transforms computer code written in the source language *E* (see *main.e*) into an assembler program in the form of a symbolic notation of commands using [Jasmin](http://jasmin.sourceforge.net). The advantages are optimization and a lower overhead. *Jasmin* is an assembler to create class files from assembler-like syntax using the JVM instruction sets. Moreover, [ANTLR](http://jasmin.sourceforge.net) is used as parser generator for reading, processing, executing and translating the structured text. Therefore, it creates a lexer as well as parser for the grammar *grammar/E.g4*. Rules consisting only of majuscule refer to the lexer and rules consisting only of minuscules refer to the parser. The workflow works as follows:

1. **Lexical analysis**: Recognizes words (lexemes) like digits or '+' from the source code with finite automatons (regular expressions). Each lexeme consists of at least one or more characters. Comments are ignored.
2. **Syntax analysis**: Builds a logical structure (AST) using a top down parser. The grammar corresponds to *LL(k)* whereby *k=1* denotes the lookahead, that means the next production is predicted on the basis of tokens whereby the content of the PDA is taken into account. The PDA processes the input from left to right by calculating a left derivation.
3. **Context Analysis**: Attributes the AST through declaration analysis and type analysis (ASG). The declaration analysis checks whether a declaration exists before use. So there is an automatic error handling. For example, the type analysis checks whether formal and current parameters match.
4. **Synthesis**: Creates assembler instructions. Since the grammar is defined recursively, the instructions are generated by a post order traverse. Allocation (components), binding (mapping from functions to components) and flow chart are taken into account. Specifically, expressions such as commands are transformed using the necessary instructions. Then, byte code is generated from it which can be executed in the JVM.

Hash tables are used to enable fast access to identifiers, strings and other constructs. To avoid problems, keywords are reserved and the layout is not ignored. For this reason, the finite automats do not need a lookahead. Furthermore, the context-free grammar is unique, i.e. the parser is deterministic. In this way, mathematical rules are implicitly observed. Before starting the code generation, a global optimization is also carried out. For example, isomorphisms are eliminated. After the code generation, there is a local optimization whereby commands are rearranged.

## Prerequisites
+ [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) or later
+ [ANTLR4](http://www.antlr.org) for reading, processing, executing and translating the structured text
+ [Jasmin](http://jasmin.sourceforge.net) to convert ASCII descriptions of Java classes into binary Java class files, suitable for loading by a Java runtime system
+ [Maven](http://maven.apache.org) to manage this project

## Installation
At first, clone or download this project. Afterwards, go to the terminal and type `mvn install` to create and install the related JAR file. To delete the created folder *target*, the command `mvn clean` must be executed. To execute the unit tests, there is the command `mvn test`. To ensure the code quality, [Google Java Format](https://github.com/google/google-java-format) was still used which formats the code. [Checkstyle](https://maven.apache.org/plugins/maven-checkstyle-plugin/) was also used. It can find class design problems, method design problems. It also has the ability to check code layout and formatting issues. To re-format the code, simply use the command `mvn com.coveo:fmt-maven-plugin:format`. For static code analysis the command `mvn checkstyle:check` must be entered.

## Language components
Among others the following features are offered:

+ Imports like `use(e.io.reader)`
+ Import calls like `String r = reader.read(): String;`
+ Macro Instructions like `#define noMain`
+ Outputs like `print("world");`
+ Variable declarations or assignments like `int a;` as well as `float a = 5.3;`
+ Function definitions like `void foo(int a, int b) { print(a*b); }`
+ Function calls like `foo(7, 8);`
+ Branches like `if (x) { a = 5; } else { a = 7; }`
+ Loops like `int i = 0; while (i < 3) { println(i); i = i + 1; }`
+ Built-in functions like `toInt(3.7);`
+ Inline assembler like `invoke "static" "java/lang/System/nanoTime"() "J";`
+ Structures like `struct Point { int x; int y; }`
+ Struct initializations like `Point p = new Point(1, 2);`
+ Arrays like `int[] a = new int[5];`
+ Arithmetic operators like `a + b`
+ Shift operators like `a >> b`
+ Relational operators like `a <= b`
+ Logical operators like `a && b`

In addition, there is comprehensive error handling. For example, it is impossible to use a variable without a declaration or to use operations with incompatible data types.

## Usage
Navigate to the folder *target* and type `java -jar *.jar` to execute the created JAR file. 

For example, to work with the project, it can be imported as a maven project into the IDE *IntelliJ*. Let us assume, for example, that the example rule *test* is to be inserted.

If the grammar is changed, the code must be adapted. To do this, the following commands must be executed after the change:

```
$ cd grammar
$ antlr -package com.runekrauss.parser -o ../src/main/java/com/runekrauss/parser/ -no-listener -visitor E.g4
```

Now look into the class *EBaseVisitor* where you will find a method called *visitTest*:

```
public T visitTest(EParser.TestContext ctx) { return visitChildren(ctx); }`
```

This method must be overwritten in the class *EVisitor* with the respective actions to traverse the tree. To test the code, the array in the method *provideCodeExpectedOutput* of the class *CompilerTest* must be extended. To view the corresponding tree, you can use the *TestRig* tool as follows:

```
$ cd target
$ java -cp classes:../lib/antlr.jar org.antlr.v4.gui.TestRig com.runekrauss.parser.E program -gui ../e/test/main.e
```

Then, a graphical user interface opens which displays the tree.

## Example

Let's assume the following code exists:

```
print(3+2*4);
```

Here, for example, a digit or ';' is a lexeme. The corresponding tree looks like this:

![Parser Tree](img/parse_tree.png "Parser Tree")

This produces over post order traverse the following assembler-like instructions:

```
.class public e_test_main
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
   .limit stack 4
   .limit locals 1

   getstatic java/lang/System/out Ljava/io/PrintStream;
   ldc 3
   ldc 2
   ldc 4
   imul
   iadd
   invokevirtual java/io/PrintStream/print(I)V

   return
.end method
```

Finally, the code can be translated into a class file using *Jasmin*. Then, it can be interpreted and executed in the *JVM*.

## More information
Generate the documentation of this project regarding the special comments with a command in your terminal, for example:

```
$ cd java
$ javadoc -d doc com.runekrauss.compiler
```

Afterwards, you will get a website with helpful information about the code. There is also a [term paper](https://github.com/RuneKrauss/chartam) describing the functionality of the compiler.