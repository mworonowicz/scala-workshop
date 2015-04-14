# scala-workshop

## Preparation

install scala  http://www.scala-lang.org/download/install.html
```
git clone https://github.com/mworonowicz/scala-workshop.git
```

## 1. Introduction to language : Hello world
- types of fields : val, val, def
- lazy fields
- printing using string format 
- call by name
- implicit
- closure

```
git pull origin hw2
scalac HelloWorld.scala
scala scalaworkshop.HelloWorld
```

## 2. Object oriented
- constructors
- companion object
- comnposition with traits
- pattern matching
- linearization

``` 
git pull origin so4
scalac ScalaObjects.scala
scala scalaworkshop.ScalaObjects
```

## 3. Collections
- creating lists and adding, prepending, appending, cons
- higher order functions
- for comprehension
- maps

```
git pull origin sc2
scalac ScalaCollections.scala
scala scalaworkshop.ScalaCollections
```

## 4. Implicit
- implicit conversion function
- implicit class

```
git pull origin si2
scalac ScalaImplicit.scala
scala scalaworkshop.ScalaImplicit
```

## 5. Generics
- implementing linked list
- variance
- lower bound type

```
git pull origin sg2
scalac ScalaGeneric.scala
scala scalaworkshop.ScalaGeneric
```
