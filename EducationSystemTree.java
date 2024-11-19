import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Main class
public class EducationSystemTree {

    public Node root;

    public EducationSystemTree() {
        root = new Node("National Education System", null);
    }

    public void systemTree() {
        // Create child nodes of root nodes
        Node primary = new Node("Primary Education", root);
        Node secondary = new Node("Secondary Education", root);
        
       //Adding child node of root nodes
        root.children.add(primary);
        root.children.add(secondary);
        
        //Create child nodes of Secondary nodes
        Node middle = new Node("Middle School", secondary);
        Node higher = new Node("Higher Education", secondary);
        
        //Adding child nodes of secondary nodes
        secondary.children.add(middle);
        secondary.children.add(higher);
        
        
        //Create leaf nodes of parent nodes
        Node kindergarten = new Node("Kindergarten", primary);
        Node grade6 = new Node("Grade 6", primary);
        Node juniorhigh = new Node("Junior High School", middle);
        Node seniorhigh = new Node("Senior High School", middle);
        Node vocational = new Node("Vocational School", higher);
        Node college = new Node("College", higher);
        
        //Adding leaf nodes in parent nodes
        primary.children.add(kindergarten);
        primary.children.add(grade6);
        middle.children.add(juniorhigh);
        middle.children.add(seniorhigh);
        higher.children.add(vocational);
        higher.children.add(college);
    }

//Display tree structure
    public void displayTree(Node node, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }

        //Display the node's name and each level'
        if (node == root) {
            System.out.println("(Root Node)\n" + node.name);
        } else if (node.parent != null && node.children.size() > 0) { 
            System.out.println("(Parent Node)\n" +" " + node.name); 
        } else if (node.parent != null) {
            System.out.println("(Child Node) " + node.name);
        } else {
            System.out.println("(Leaf Node) " + node.name);
        }

        for (Node child : node.children) {
            displayTree(child, level + 1);
        }
    }

//Testing output using switch and boolean
    public static void main(String[] args) {
        EducationSystemTree tree = new EducationSystemTree();
        tree.systemTree();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Display Tree");
            System.out.println("2. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    tree.displayTree(tree.root, 0);
                    break;
                case 2:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Node class
    public static class Node {
        public String name;
        public Node parent;
        public List<Node> children = new ArrayList<>();

        public Node(String name, Node parent) {
            this.name = name;
            this.parent = parent;
        }
    }
}
