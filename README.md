# Max-Side-Length
A divide-and-conquer program that solves the following problem:

Given a set of two-dimensional points, the goal is to compute the maximum side length of the square that can be drawn around each point, such that no two squares intersect, except at the sides.
## Notes:
-	Each point will be at the center of the square around it.
-	The sides of the squares can only be horizontal and vertical.

## Input file: 
The input to the program will be a single file that has several test cases. Each test case starts with the number of points on a single line, followed by each point on a separate line. All inputs will be integers. The number of points can be up to 10<sup>6</sup> points, and each dimension of the points are in the range -10<sup>6</sup> to 10<sup>6</sup>.
## Output file:
For each test case, output a single number on a separate line.

### Sample case:
#### Input:
4
1 1
3 3
5 5
6 6
#### Output
1
