# Composite design pattern

The Composite pattern is used to represent a hierarchical structure. We can employ this pattern when our code is organized in a tree-like structure, comprising both simple and composite nodes.

This pattern has following components.

- Base class interface: This is the type of the simple and complex objects. Both will implement this so they can be categorize as a same type. Client will use only this interface to interact with composite structure.
- Leaf node: This is the building block component of this pattern, which can not be further decompose because as it doesn't have reference to other components.
- Composite node: This is the composition of multiple nodes. It may have combination of multiple leaf nodes and other composite nodes.

Both leaf nodes and composite nodes implements same Base class interface.

Advantages of Composite design patterns

- This is useful when we can organize our code into a tree-like structure. It helps in reducing complexity, more components can be added easily if we follow this structure.
- Client is not coupled with the concerate classed, instead it use only Base class interface.

Disadvantages of Composite design pattern

- It might be difficult to provide a common interface for the classes whose functionality differs too much. Sometimes, we have to over-gernalize the interface.

## Example

We are creating a graphic library which supports creating different shapes using Java Swing framework. Different shapes supported by library are following.

- Line
- Circle
- Rectangle
- Complex shapes (which may contain multiple lines, circle etc. along with their own defined shape)

 we need to create this library which supports creating simple shapes like line, circle, rectangle and complex shapes.
