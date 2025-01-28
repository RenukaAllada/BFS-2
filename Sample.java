/************************PROBLEM-1*******************/
//BFS
//TC:0(N)
//SC:0(N)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> s=new LinkedList();
        s.add(root);
        while(!s.isEmpty()){
            int size=s.size();
            for(int i=0;i<size;i++){
                root=s.poll();
                if(i==size-1){
                    result.add(root.val);
                }
                if(root.left!=null){
                    s.add(root.left);
                }
                if(root.right!=null){
                    s.add(root.right);
                }
            }
        }
        return result;
    }
}

//DFS
//TC:0(N)
//SC:0(H)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        result=new ArrayList<>();
        dfs(root,0);
        return result;
    }

    private void dfs(TreeNode root,int level){
        if(root==null){
            return;
        }
        if(level==result.size()){
            result.add(root.val);
        }

        dfs(root.right,level+1);
        dfs(root.left,level+1);
    }
}
/************************PROBLEM-2*******************/

//BFS Solution
//TC: O(N)
//SC: 0(N)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        Queue<TreeNode> s=new LinkedList<>();
        s.add(root);
        boolean x_found=false,y_found=false;
        while(!s.isEmpty()){
            int size=s.size();
            for(int i=0;i<size;i++){
                root=s.poll();
                if(root.left!=null && root.right!=null){
                    if((root.left.val==x && root.right.val==y) ||
                            (root.left.val==y && root.right.val==x)){
                        return false;
                    }

                }
                if(root.val==x){
                    x_found=true;
                }
                if(root.val==y){
                    y_found=true;
                }
                if(root.left!=null){
                    s.add(root.left);
                }
                if(root.right!=null){
                    s.add(root.right);
                }
            }
            if((x_found==true && y_found==false) || (x_found==false && y_found==true)){
                return false;
            }
        }
        return true;
    }
}

//DFS Solution
//TC: O(n)
//SC: 0(h)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int x_level=-1,y_level=-1;
    TreeNode x_parent, y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        dfs(root,null,0,x,y);
        if((x_level==y_level) && (x_parent!=y_parent)){
            return true;
        }else{
            return false;
        }
    }

    private void dfs(TreeNode root,TreeNode parent,int level,int x,int y){
        if(root==null || (x_level!=-1 && y_level!=-1)){
            return;
        }
        if(root.val==x){
            x_parent=parent;
            x_level=level;
        }
        if(root.val==y){
            y_parent=parent;
            y_level=level;
        }
        dfs(root.left,root,level+1,x,y);
        dfs(root.right,root,level+1,x,y);
    }
}

