# Lab - Binary Search Tree, kth smallest

Modify the `BinarySearchTree` class by adding a method named `kth_smallest`
that finds the kth smallest key inside the tree in O(log n) time.
(The k's start at 0.) If there is no kth smallest element (because the
BST is not big enough), then throw an `Exception`.
Hint: `BSTNode` should keep a count of the number of nodes in
its left subtree. This may require changing or adding code in several
places with the `BSTNode` and `BinarySearchTree` classes.

