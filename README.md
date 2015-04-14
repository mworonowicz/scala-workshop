# scala-workshop

## Preparation

install scala  http://www.scala-lang.org/download/install.html
```
git clone https://github.com/mworonowicz/scala-workshop.git
cd scala-workshop
```

## 1. Introduction to language : Hello world
- types of fields : val, val, def
- lazy fields
- printing using string format 
- call by name
- implicit
- closure

```
git checkout hw2
scalac HelloWorld.scala
scala scalaworkshop.HelloWorld
```

## 2. Classes and objects
- constructors
- companion object
- comnposition with traits
- pattern matching
- linearization

``` 
git checkout so4
scalac ScalaObjects.scala
scala scalaworkshop.ScalaObjects
```

## 3. Collections
- creating lists and adding, prepending, appending, cons
- higher order functions
- for comprehension
- maps

```
git checkout sc2
scalac ScalaCollections.scala
scala scalaworkshop.ScalaCollections
```

## 4. Implicit conversions
- implicit conversion function
- implicit class

```
git checkout si2
scalac ScalaImplicit.scala
scala scalaworkshop.ScalaImplicit
```

## 5. Generic classes
- implementing linked list
- variance
- lower type bounds

```
git checkout sg2
scalac ScalaGeneric.scala
scala scalaworkshop.ScalaGeneric
```
