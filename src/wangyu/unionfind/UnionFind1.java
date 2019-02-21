package wangyu.unionfind;

/**
 * 作者：王宇
 * 创建时间：2019/2/20 0020 10:05
 * 描述：并查集树形结构的实现
 */
public class UnionFind1 {
    private int[] parent;
    private int count;
    private int[] sz;//sz[i]代表的是以i为根的集合中元素的个数
    public UnionFind1(int count){
        this.count = count;
        parent = new int[count];
        sz = new int[count];

        for (int i = 0; i < count; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int p){
        while (parent[p] != p)
            p = parent[p];
        return p;
    }

    public boolean isConnection(int p, int q){
        if (find(p) == find(q)){
            return true;
        }
        return false;
    }

    //把p和q连接起来
    public void union(int p, int q){
        int proot = find(p);
        int qroot = find(q);
        if (proot == qroot)
            return;

//        for (int i = 0; i < count; i++) {
//            if (find(i) == )
//        }

        if (sz[proot] < sz[qroot]){
            parent[proot] = qroot;
            sz[qroot]+=sz[proot];
        }
        else {
            parent[qroot] = proot;
            sz[proot] = qroot;
        }    }
}
