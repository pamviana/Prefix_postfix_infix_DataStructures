
Project developed by Professor Ayan Dutta for the Data Structures class at University of North Florida, Fall 2021.

**#Definitions**

Infix Expression: The operator is in between the two operands. E.g., a + b, a - b, and so on.

Prefix Expression: The operator is before the two operands. E.g., + a b, - a b, and so on.

Postfix Expression: The operator is after the two operands. E.g., a b +, a b -, and so on.

**#Instructions**

In this assignment, you will take one Infix expression as input and convert it to both Postfix expression, and Prefix expression.

Next, you will display the converted versions.

See the example below.

Finally, you will evaluate the expression, and print out the solution.

See the example below.
You can assume only integer numbers, +-*/ operators and parentheses are part of the input expression. However, the evaluated output should be of double type.

The characters in the input and the output expressions will be separated by single spaces.

See the example below.

Please follow the same output pattern as shown below. 

Note: The test run below is just a sample. It does not imply that I will test your code with only this particular input. Make sure you thoroughly test your code before submitting it.

**#Hints**

You can use Stacks for this task.

You can use the Stacks class written by Professor Dutta in the classroom as a base, but cannot use Java's in-built Stack/LinkedList libraries.

You can take the input as a string by reading the line from the console.

You only need to solve the problem for one input given by the user.

**#Sample Run**

Input Infix Expression: ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )

Postfix version: 2 3 4 + 5 6 * * +

Prefix version:  + 2 * + 3 4 * 5 6

Evaluation: 212.00
