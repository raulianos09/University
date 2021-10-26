package HashMap;

import java.util.Objects;

public class Pair<Key, Value> {
    public Key first;
    public Value second;

    @Override
    public String toString() {
        return  first + " ---------- "+ second + "\n";
    }

    public Pair() {
    }

    public Pair(Key first, Value second)
    {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

}
