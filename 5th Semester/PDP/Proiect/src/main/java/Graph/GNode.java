package Graph;

import java.util.Objects;

public class GNode {
    private int color;
    private int weight;
    private int nodeID;

    public GNode(int nodeID) {
        this.nodeID = nodeID;
    }

    public int getNodeID() {
        return nodeID;
    }

    public void setNodeID(int nodeID) {
        this.nodeID = nodeID;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "GNode{" +
                "color=" + color +
                ", weight=" + weight +
                ", nodeID=" + nodeID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GNode))
            return false;
        GNode obj = (GNode) o;
        return obj.getNodeID() == this.getNodeID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeID);
    }
}
