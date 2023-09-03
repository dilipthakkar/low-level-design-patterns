# Facade Design pattern

Facade means imposing another face onto one.

If we are using an extrnal library which has multiple classes, then our client code will be tightly coupled with these classes.
But is we are using only some of the functionality of this 3rd party library then we can create an extra layer onto this library
which will implement only the neccassary features that our client requires from this library. This extra layer interface is called as facade.

Now, client only has to interact with one interface of facade instead of multiple classed and types.

Some advantages of Facade pattern.

- Client only has to interact with one facade interface instead of multiple classes and typs of 3rd party library.
- In furture, if 3rd party library change some of its classes or functionality then we just have to change the code of facade class, it will not affect client code.
- 3rd party library (complex subsystem) may have complex logics and multiple types, with the help of facade we seperate the interacation of client code with 3rd party library to a single facade class.

some disadvantages of Facade pattern.

- Sometimes facade class becomes so complex and big that it increases the complexity of code, which is a anti-pattern. So if our facade class becomes bulky then we should seperate facade logic into multiple classes.

## Example

We are implementing a video editor, we requires to extract audio content for a video for a perticular feature only. We have a Adobe library which provides video and audio related features. However, we don't want to couple our whole client code with the Adobe library classes, as in near future we will create this extraction functionality by our own.

We can use facade pattern to create an extra layer between client code and Adobe library.