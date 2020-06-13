package algo_expert.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * You're given a `Node` class that has a name and an array of optional children nodes. When put together,
 * nodes form an acyclic tree-like structure.
 */
public class DepthFirstSearch {
    static class Node {
        String  name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            array.add(this.name);
            for (int i = 0; i < children.size(); i++)
                children.get(i).depthFirstSearch(array);
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
