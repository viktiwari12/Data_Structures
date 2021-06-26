#include <iostream>
#include <vector>
using namespace std;
class treenode
{
    public:
        int val;
        treenode* left = nullptr;
        treenode* right = nullptr;
    treenode(int val )
    {
        this->val = val;
    }
};
//function to find the hight of the tree
int hight(treenode* root)
{
    return root == nullptr ? 0 : hight(root->left) + hight(root->right) + 1;
}
//main fumction
int main()
{
    int num;
    cin>>num;
    treenode* tree = new treenode(num);

}