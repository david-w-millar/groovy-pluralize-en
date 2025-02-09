# (ARCHIVED) Groovy Pluralize Module
David W Millar <david.w.millar@gmail.com>

image:https://travis-ci.org/david-w-millar/groovy-pluralize-en.svg["Build Status", link="https://travis-ci.org/david-w-millar/groovy-pluralize-en"]
image:http://img.shields.io/maven-central/v/org.millarts/groovy-pluralize-en.svg["Maven Coordinates"]


> ***Important*** This project has been archived, as it no longer seems worth maintaining with so many better options out there. Feel free to reach out to me if you have any questions or interest in reviving it.


A lightweight Groovy extension module that adds the functionality
to get plural inflections for words. Suitable for most English applications.

For more robust needs, checkout IBM's more comprehensive and feature rich
http://www-01.ibm.com/software/globalization/icu/[International Components for Unicode] library.


### Installation

Include the jar is in your classpath, or add it as a dependency to your favorite build tool.
Groovy does the rest.
Requires groovy 2.0 or later.


.Gradle and Grails
```groovy
compile 'org.millarts:groovy-pluralize-en:0.2.1'
```

.Groovy Grape
```groovy
@Grapes(
  @Grab(group='org.millarts', module='groovy-pluralize-en', version='0.2.1')
)
```

.Maven
```xml
<dependency>
  <groupId>org.millarts</groupId>
  <artifactId>groovy-pluralize-en</artifactId>
  <version>0.2.1</version>
</dependency>
```

### Usage

.Example Usages
```groovy
// Plural Inflection
assert 'mustache'.plural() == 'mustaches'
assert 'wolf'.plural()     == 'wolves'

// Plural Inflection with Cardinality
assert 'codex'.plural(1) == 'codex'
assert 'codex'.plural(2) == 'codices'
assert 'codex'.plural(8) == 'codices'

// Capitalization
assert 'Life'.plural() == 'Lives'

// Unfortunately, capitalization does not behave consistently for certain words. EG:
assert 'Tooth'.plural() == 'teeth'
```


### Building

This project uses gradle for builds, and includes wrapper scripts
so that it is not necessary to explicitly install gradle to build and test the project.

.Gradle Examples
```shell
$ ./gradlew tasks   <1>
$ ./gradlew jar     <2>
$ ./gradlew test    <3>
$ ./gradlew check   <4>
```
<1> Lists the available tasks for this project
<2> Builds the jar
<3> Runs tests
<4> Runs tests and checks (eg: code quality checks)

### Under the Hood

This module uses the https://github.com/atteo/evo-inflector[evo-inflector] project
under the hood, which is based off of Damian Conway's paper
http://www.csse.monash.edu.au/~damian/papers/HTML/Plurals.html[An Algorithmic Approach to English Pluralization].
It tends to get things right. See the https://github.com/atteo/evo-inflector[evo-inflector] project for more information.


### License

This project is licensed under the terms of the
http://www.apache.org/licenses/LICENSE-2.0.html[Apache License, Version 2.0].

&copy; 2014-2025 David W Millar

// vim: set syntax=asciidoc:
