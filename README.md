# Kotlin_Learning
# https://kotlinlang.org/docs/reference/

Some basic things about Kotlin:

- Kotlin distinguishes between nullable and non-nullible data types --> Eliminate many compile errors
- Kotlin has both object and functional constructs

2 types of variables in Kotlin: changeable (var) & Unchangeable (val).
Cannot change the type of variables once it's determined.

- By default, Kotlin vars cannot be null. Specify that it can be null by using "?", for example:
var marbles : Int? = null;      //? may specify this one is "nullable".

- The ? operator can be used to check if an object is null or not. For example: 
return fishTreat?.dec()  ?: 0    first check if fishTreat is null or not. Then return 0 or call the function .... 

- Range in Kotlin:      in 1..50

- About "UNCHANGEABILITY" of 'val' : It only makes the object reference unchangeable !--i.e; cannot reassign it. But the object it points to still can be manipulated / changed.


----------------------------------------------------------ARRAY--------------------------------------------------------------------
- Typed Array ( E.g: val sth = intArrayOf(1,2,3)) -> Same type.
- Untyped Array ( E.g: val abc = arrayOf("fish",1)) -> Any type

- Nearly everything in Kotlin is an expression (i.e, have a value), even a normal statements. e.g: val isHot = if (a>50) true else false
Some exceptions would be "for" and "while" statements, there are not counted as expressions in Kotlin.
- Dollar sign $ in Kotlin marks a "statement/expression" in a string. 
  E.g: println("You are ${if (temperature > 30 ) "fried" else "safe"} fish");

---------------------------------------------------------"WHEN"---------------------------------------------------------------------
- switch in Kotlin:       ( NO need to add break at the end ... )
when (a) {
    val -> ...
    val2 -> ...
    elss ->...
}
- "when" with no parameters: Act as a sequence of if-else-if checks

-------------------------------------------------------Filter--------------------------------------------------
- Filter is a standard library function on list.
E.g: var decor : List<String> = listOf {//some strings}
    println(decor.filter{it[0]=='p'}) //check & print out the list elements that starts with letter 'p'. "it" here refers to itself
By default, the filter statement returns a new list.
  
----------------------------------------------------Lambda----------------------------------------------------------
  - Lambda: In other languages, also called anonymous functions/function literals/etc...
  - An expression that makes a function. -- declare a function that has no name.
  Some examples of lambda expression:
  1.  val rollDice0 = { sides: Int ->
       if (sides == 0) 0
       else Random().nextInt(sides) + 1
       }
        //Not using function notation
  2.   val rollDice2: (Int) -> Int = { sides ->
        if (sides == 0) 0
        else Random().nextInt(sides) + 1
        }
        //Using function notation
   
   Function type notation is more readable, which reduces errors, clearly showing the what type is passed in and what type is returned.
             
             << I hate lambda and functional programming so I will just leave it here and come back whenever I need ... >>
           
--------------------------------------------------------CLASS-------------------------------------------------------------------
- One nice thing in Kotlin class attribute: Every attribute has a default getter that CAN BE OVERRIDEN (Example in code) that can be accessed by using: Object.Attribute (rather than Object.getAttribute()). The setter is accessed everytime u SET the attribute (even without directly call the setter func.)

- Default access specifier: PUBLIC. Everywhere.
- Others: 
 + private - File/Class
 + internal - Module (A set of Kotlin files compiled tgt)
 + protected - same
 
  Constructors take less line of codes to write !
 - Primary constructors: part of the class header. The primary constructor doesn't have any block of codes, so if required, use the init keyword for the initializer.
 - Secondary constructors: MUST contain a call to the primary constructor using "this".
 
 - By default, class/variables in Kotlin are final. If we want to override, needs to specify it as 'open'.
 
 --------------------------------------------ABSTRACT CLASSES & INTERFACES--------------------------------------
 - Abstract classes have constructor while interfaces do not have constructor logics. <<Only difference>>
 - Polymorphism works similar to Java
 - BOTH of them can have implementation of methods !!!!! (default implementation)
 - "object" keyword: Allow a class to have ONLY one object declaration (similar to static class...)
 - Interface Delegation: Let you add features to a class via composition. With the use of the "By" keyword -- implementing an interface by deferring all calls to the instances "By" refers to ... <Example in the commit "Interface Delegation">
  
 ------------------------------------------------ DATA CLASSES -----------------------------------------------------------
 - To get data class's properties and assign them to variables, use a process called "decomposition". Create variables, one for each property and assign the data object to it. <Example in the commit "Data Class"> 
 
-----------------------------SPECIAL PURPOSE CLASSES: OBJECT, ENUM, SEALED------------------------------------------------
 - Enum actually defines a class and u can give them properties & methods. 
 - Sealed class and only be inherited inside the file which it's declared.
 
 ---------------------------------------PAIRS & MAPS---------------------------------------------------------------------------
 - Similar to an element of map in Java. Map one element to another
 - Allow 'nested' pair.
 - Keyword "to" for creating a pair: E.g a to b => Pair<a,b> 
 - Map using mapOf ... is basically a list of pairs. Can have mutable map also.
 
 -------------------------------------Extension functions----------------------------------------------------------------------
 - E.g:
 
                   << fun class.extenFunc() ..... {} >>
 - Especially helpful to add functionalities to classes u do not own.
 - Extension functions are resolved STATICALLY - at compile time. And the compiler, it just looks at the type of the variable. [So beware of Polymorphism when you are using extension functions!]
 - Extension properties are available, too.
 
 -------------------------------------------------Generics----------------------------------------------------------------------
 - E.g: 
 class Aquarium<T>(...)
 BY DEFAULT: T is set to be any NULLABLE type (a bit weird, isn't it)
  To make the generic pass-in non-nullable: class Aquarium<T: Any>(...)
  
  GENERICS OUT & IN
- If we want to pass a generic as a function param, needs to mark the class as "OUT".
- IN type can only be passed into an object. OUT type can only be passed out of an object or returned.
- OUT type can be used as return value and IN type can be used as parameters.
- OUT type may also be used as a pass-in param for a global function?

  GENERIC FUNCTIONS
 - For a generic method within a class that use checks, u need to use "inline" and "reified". Non-reified type are only available at compile time, but can't be used at runtime by the program. 
 - The asterisk * means it would accept any type passed into the generic.
 
 
------------------------------------------------MORE ABOUT LAMBDAS--------------------------------------------------------------
Time to get into more advanced topics of Kotlin: lambda.

- Usually, when a higher-order func is called, a new lambda obj will be created, creating overhead.
So, we can specify that H-O func as inline.A promise that everytime myWith is called, it will actually transform the source code to inLine, the function. That is, the compiler will change the code to replace the Lambda with the instructions inside the Lambda --> zero overhead.
- Without 'inline', an object is created every time with every call. With 'inline', the call to Lambda is replaced with the contents of the function body of the Lambda; so no object is created. 
