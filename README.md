numbers-to-text
===============

kata on numbers to text conversion like:  
`1 becomes one`  
`2 becomes two`  
`56945781 becomes fifty six million nine hundred and forty five thousand seven hundred and eighty one`

To Run
======

Use maven 2 or 3 with Java 1.5 or greater and run the command: `mvn clean test exec:java`

Approach
========

I often find it quite difficult to test drive algorithmic katas as you end up with expected input and output tests which don't check how the algorithm itself works, just prove that it has acceptable input and output.

My solution to this problem was heavily influenced from the similarly algorithmic Roman numerals Kata.

You generally approach that by trying to represent the nuances of Roman numerals in either code or data form. You either represent the tricky 'IV' == 4 as a special processing rule, or you just make a lookup table that knows how to represent 4.

With this kata you are given the same problem with the teenage numbers in european languages (11 is eleven).  I decided that I'd take the Roman numerals approach of sticking all interesting numbers into a map and use an algorithm to work out any given number using this map.

This approach initially falls down when you try to calculate any number over 1000 due to the special grammatical rules that are in use when building sentences.  I decided to split the number into different parts, usually represented with a comma while writing the words, and using the map based approach to work out the individual parts of the word. With this in place you can work out a grammatically correct representation of a given number.

For example: 56945781  
1. First split it into parts of 3s: `56, 945, 781`  
2. Work out the words version of each part: `fifty six, nine hundred and forty five, seven hundred and eighty one`  
3. Add the number part to each: `fifty six million, nine hundred and forty five thousand, seven hundred and eighty one`  
4. Then do a simple join to get the end result

Alternatives
============

As mentioned, you are always facing a trade-off between making a massive lookup table and coding the rules of the language yourself.  The problem with a lookup table here is that would take up copious amount of memory space.  This approach looks even worse when you consider internationalization per language.

The approach here takes a slight hybrid as I added the hundreds (100...900 in 100 increments) to the map of known translations as it simplified the code base.

In the Wild
===========

You can see from ICU4J, which provides a library to solve this problem, that it's a very complicated problem to solve:
[http://icu-project.org/apiref/icu4j/com/ibm/icu/text/RuleBasedNumberFormat.html](http://icu-project.org/apiref/icu4j/com/ibm/icu/text/RuleBasedNumberFormat.html)