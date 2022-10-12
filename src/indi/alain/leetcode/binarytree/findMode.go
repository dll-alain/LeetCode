package main

// TreeNode BST findMode
type TreeNode struct {
     Val int
     Left *TreeNode
     Right *TreeNode
 }
func findMode(root *TreeNode) []int {
	maxCount := 1
	count := 1
	res := make([]int, 0)
	var pre *TreeNode
	var traversal func(root *TreeNode)
	traversal = func (root *TreeNode) {
		if root == nil {
			return
		}
		traversal(root.Left)
		if pre != nil && pre.Val == root.Val {
			count++
		} else {
			count = 1
		}
		if count >= maxCount {
			if count > maxCount && len(res) > 0 {
				res = []int{root.Val}
			} else {
				res = append(res, root.Val)
			}
			maxCount = count;
		}
		pre = root
		traversal(root.Right)
	}
	traversal(root)
	return res
}