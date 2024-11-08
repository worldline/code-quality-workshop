authors: Alexandre Touret & Philippe Vincent
summary: Code Quality Workshop
id: code-quality-workshop
categories: quality, java
environments: Web
status: Published
feedback link: https://github.com/worldline/code-quality-workshop/issues


# Code quality workshop

## Introduction
This workshop aims to spread coding best practices to young developers (interns, < 3y XP ,..). For instance, we could provide exercices about logging or error handling best practices.
Through a real life inspired application, the trainees could deal with coding basics: clean code, OOP principles, TDD and such like (see below) while submitting their first Pull Reque

During this workshop we will cover:

* OOP principles, SOLID
* Clean code
* Naming
* Classes
* TDD
* Exception/error handling
* Log management
* GIT (conventional commits)


### Getting involved?

The source code is available on [GitHub](https://github.com/worldline/code-quality-workshop/).

Feel free to raise any issues or participate!

## Prerequisites

### Skills

| Skill                                  | Level | 
|----------------------------------------|---|
| [Java](https://www.oracle.com/java/)   | novice |   
| [Maven](https://www.maven.apache.org/) | novice |

### Tools
#### If you want to execute this workshop locally
You **MUST** have set up these tools first:
* [Java 21+](https://adoptium.net/temurin/releases/?version=21)
* [Maven 3.9](https://www.maven.apache.org/)
* [Docker](https://docs.docker.com/) & [Docker compose](https://docs.docker.com/compose/)
* Any IDE ([IntelliJ IDEA](https://www.jetbrains.com/idea), [VSCode](https://code.visualstudio.com/), [Netbeans](https://netbeans.apache.org/),...) you want

Here are commands to validate your environment:

**Java**

```jshelllanguage
java -version
openjdk version "21.0.1" 2023-10-17 LTS
OpenJDK Runtime Environment Temurin-21.0.1+12 (build 21.0.1+12-LTS)
OpenJDK 64-Bit Server VM Temurin-21.0.1+12 (build 21.0.1+12-LTS, mixed mode, sharing)
```

**Maven**

```jshelllanguage
❯ mvn --version
    Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)
    Maven home: /home/alexandre/.sdkman/candidates/maven/current
    Java version: 21.0.4, vendor: Eclipse Adoptium, runtime: /home/alexandre/.sdkman/candidates/java/21.0.4-tem
    Default locale: en, platform encoding: UTF-8
    OS name: "linux", version: "5.15.153.1-microsoft-standard-wsl2", arch: "amd64", family: "unix"
```


## Clean code
Clean code is a 
based on the famous book Clean code by R. MARTIN. It aims to help (not only) beginners to embrace the principles described in the book.

Clean code refers to code that is easy to understand, maintain, and extend. It is written in a way that is clear and concise, making it easier for other developers to read and work with. 

Robert C. MARTIN published the famous book ["Clean Code: A Handbook of Agile Software Craftsmanship"](https://www.oreilly.com/library/view/clean-code-a/9780136083238/).   
We strongly recommend reading it. 
It's pretty straightforward is goes direct to the point.

Here are some of the most important principles and rules of clean code:

### Meaningful Names

Use descriptive and meaningful names for variables, functions, classes, and other entities. Names should convey the purpose and usage of the entity.


#### Variables

We should choose a name that specifies what is being measured and the unit of that measurement.
We should use pronouncable words (eg. ``functionPZQ`` ). There are some exceptions (eg. ``SSN``).

```java
 int d; // elapsed time in days.
```

should be transform into

```java
 int elaspedTimeInDays
``` 

#### Classes

As variable names, class names should be representative of business vocabulary.
Classes and objects should have noun or noun phrase names like ``Customer``, ``WikiPage``, ``Account``, and ``AddressParser``.
Avoid words like ``Manager``, ``Processor``, ``Data``, or ``Info`` in the name of a class.
A class name should __NOT be a verb__.

#### Methods

Methods should have verb or verb phrase names like ``postPayment``, ``deletePage``, or ``save``.
Accessors, mutators, and predicates should be named for their value and prefixed with get, set.

#### Pick One Word per Concept
Pick one word for one abstract concept and stick with it.
For instance, it’s confusing to have fetch, retrieve, and get as equivalent methods of different classes.
How do you remember which method name goes with which class?
Likewise, it’s confusing to have a controller and a manager and a driver in the same code base.
What is the essential difference between a ``DeviceManager`` and a ``Protocol- Controller``?

### Single Responsibility Principle (SRP)
Each class or function should have only one reason to change, meaning it should have only one job or responsibility.

### Open/Closed Principle (OCP)
Software entities should be open for extension but closed for modification. This means you should be able to add new functionality without changing existing code.

### Liskov Substitution Principle (LSP)
Subtypes must be substitutable for their base types without altering the correctness of the program.

### Interface Segregation Principle (ISP)
Clients should not be forced to depend on interfaces they do not use. Split large interfaces into smaller, more specific ones.

### Dependency Inversion Principle (DIP)

High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions.

### DRY (Don't Repeat Yourself)
Avoid code duplication by abstracting common functionality into reusable components.

### KISS (Keep It Simple, Stupid)
Write simple and straightforward code. Avoid unnecessary complexity.

### YAGNI (You Aren't Gonna Need It)
Do not add functionality until it is necessary. Avoid over-engineering.

### Separation of Concerns
Different parts of the code should handle different concerns. For example, business logic should be separated from data access logic.

### Commenting and Documentation
Use comments and documentation to explain why certain decisions were made, not just what the code is doing. However, strive to write self-explanatory code that minimizes the need for comments.

The proper use of comments is to compensate for our failure to express ourselves in code.
So when you find yourself in a position where you need to write a comment, think it through and see whether there isn't some way to turn the tables and express yourself in code.

Code changes and evolves, but comments don't always follow them and And all too often the comments get separated from the code they describe and become orphaned blurbs of ever-decreasing accuracy

#### Good comments

##### Legal Comments
```java
/*
 * Copyright (c) Worldline 2017 - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */
```
##### Informatives Comments

Ex: For explain the return value of an abstract method
```java
/**
*Returns an instance of Responder being tested
*/
protected abstract Responder responderInstance();
```

##### Explanation of Intent

Sometimes it is useful to provide basic information with a comment.
For example :
```java
/**
*return Coordinates in cartesian coordinate system
*/
public Coordinates getCoordinates();
```
But it is better to use the name of the function to convey the information as much as possible.
```java
public Coordinates getCartesianCoordinates();
```

#### Warning of Consequences

Ex:
```java
// Don't run unless you
// have some time to kill
public void testWithBigFile(){
writeLinesToFile(10000000);
}
```

### Error Handling

Handle errors gracefully and provide meaningful error messages. Use exceptions for exceptional conditions and avoid using them for control flow.

#### Don't use ``NULL``

If you return null values as

```java
public List<Geometry> getGeometries(){
    return geometries;
}
```

You have to handle ``null`` in your code.

```java
if( myclass.getGeometries()==null){
    // do some stuff
}
    
}
```

Prefer this code

```java
public List<Geometry> getGeometries(){
    return Optional.ofNullable(geometries).orElse(Collections::emptyList);
}
``` 

In this way you don't have to handle ``null`` and prevent ``NullPointerException``.


#### Use exceptions only for exceptional conditions

Don't use exceptions for testing ( number format, array size,...)

```java
try {
    int i = 0;
    while(true){
        range[i++].climb();
        }
    } catch (ArrayIndexOutOfBoundsException e) {}
```   

There are some things wrong with this reasoning:
* Because exceptions are designed for exceptional circumstances, there is little incentive for JVM implementors to make them as fast as explicit tests.
* Placing code inside a try-catch block inhibits certain optimizations that JVM implementations might otherwise perform.

__Exceptions are, as their name implies, to be used only for exceptional conditions; they should never be used for ordinary control flow.__

#### Use checked exceptions for recoverable conditions and runtime exceptions for programming errors.

If an exception cannot be recoverable (eg. database connection is broken), don't use checked exception.
However, catch the exceptions at the boudary of your system to encapsulate them into appropriate errors for your client.

Use checked exceptions for conditions from which the caller can reasonably be expected to recover.

##### Avoid unnecessary use of checked exceptions

Prefer ``RuntimeException``.
If you don't have to check an exception, let it throw to the caller.
Catch it on the boundary of your system to filter and encapsulate the error with appropriate error codes

#### Favor the use of standard exceptions

There are plenty standard interfaces. Use them instead creating custom exceptions.

You can find below some examples

|Exception| Occasion for Use|
----------|:---------------|     
|IllegalArgumentException| Non-null parameter value is inappropriate|
|IllegalStateException |Object state is inappropriate for method invocation|
|NullPointerException |Parameter value is null where prohibited|
|IndexOutOfBoundsException |Index parameter value is out of range|
|ConcurrentModificationException |Concurrent modification of an object has been detected where it is prohibited|
|UnsupportedOperationException | Object does not support method|

### Document all exceptions thrown by each method

Document on your javadoc all the exceptions thrown by your method


```java

/**
* ....
*
* @throws IndexoutofBoundsException : the index is too high
*/
public E get(int index){
    ListIterator<E> iterator = listIterator(index);
    
    try{
        return i.next();
        
    }catch(NoSuchElementException e){
        throw new IndexoutofBoundsException("index :"+index);
    }
}

```
### Testing
Write automated tests to verify the correctness of the code. Use Test-Driven Development (TDD) to write tests before writing the actual code.

#### The Three Laws of TDD
By now everyone knows that TDD asks us to write unit tests first, before we write production code.
But that rule is just the tip of the iceberg.

Consider the following three laws:
1. First Law: You may not write production code until you have written a failing unit test.
2. Second Law: You may not write more of a unit test than is sufficient to fail, and not compiling is failing.
3. Third Law: You may not write more production code than is sufficient to pass the currently failing test.

#### Keep your tests clean

#### Organization

##### F.I.R.S.T

Clean tests follow five other rules that form the above acronym:

###### Fast Tests should be fast

They should run quickly.
When tests run slow, you won’t want to run them frequently.
If you don’t run them frequently, you won’t find problems early enough to fix them easily.
You won’t feel as free to clean up the code.

###### Independent Tests should not depend on each other

One test should not set up the conditions for the next test.
You should be able to run each test independently and run the tests in any order you like.
When tests depend on each other, then the first one to fail causes a cascade of downstream failures, making diagnosis difficult and hiding downstream defects.

##### Repeatable Tests should be repeatable in any environment

You should be able to run the tests in the production environment, in the QA environment, and on your laptop while riding home on the train without a network.
If your tests aren’t repeatable in any environment, then you’ll always have an excuse for why they fail.
You’ll also find yourself unable to run the tests when the environment isn’t available.

##### Self-Validating The tests should have a boolean output

Either they pass or fail.
You should not have to read through a log file to tell whether the tests pass.
You should not have to manually compare two different text files to see whether the tests pass.
If the tests aren’t self-validating, then failure can become subjective and running the tests can require a long manual evaluation

#### Assertions

Test one assertion by method in your test. Use this naming convention

```java
    @Test
    void should_get_a_lastkownmileage() throws Exception {
    ...
    }
    
    [...]
    
     @Test
        public void should_create_partner_and_relations() {
    ...
        }
```

#### Given ... When ... Then

In a method, your test should be organized using this following pattern

```java
    @Test
    void should_get_a_lastkownmileage() throws Exception {
    // given 
        // the context
    // when
        // the user apply some actions
    //then
        // we should have this result
    }
```

### Refactoring

Continuously improve the code by refactoring it. Refactoring involves changing the internal structure of the code without changing its external behavior to make it more readable and maintainable.

### Consistent Formatting

Follow a consistent coding style and formatting rules to make the code more readable.

You should choose a set of simple rules that govern the format of your code, and then you should consistently apply those rules.

If you are working on a team, then the team should agree to a single set of formatting rules and all members should comply.

#### Vertical formatting

How big should a source file be ?

it should be as small as you can.
Small files are usually easier to understand than large files are.

for example FitNesse is close to 50 000 lines, and most of the files are 200 lines long with an upper limit of 500.

#### The newspaper metaphor

Think of a well-written newspaper article. You read it vertically. At the top you expect a
headline that will tell you what the story is about and allows you to decide whether it is
something you want to read.
The first paragraph gives you a synopsis of the whole story.As you continue downward, the details increase.

We would like a source file to be like a newspaper article. The name should be simple
but explanatory. It must tell you if you are in the right module or not.

#### Vertical Openness Between Concepts

Each group of lines represents a complete thought. those thoughts should be separated from each other with blank lines.

#### Indentation

A source file is a hierarchy rather like an outline.
To make this hierarchy of scopes visible, we indent the lines of source code in proportion to their position in the hierarchy.
Statements at the level of the file, such as most class declarations, are not indented at all. Methods within a class are indented one level to the right of the class.
Implementations of those methods are implemented one level to the right of the method declaration. Block implementations are implemented one level to the right of their containing block, and so on.

## Log management

## Git (conventional commits)
