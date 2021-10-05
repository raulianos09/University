package Model.Type;

import Model.Value.RefValue;
import Model.Value.Value;

import java.util.Objects;

public class RefType implements Type{
    private Type inner;

    public RefType(Type inner) {
        this.inner = inner;
    }

    public Type getInner() {
        return inner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RefType refType = (RefType) o;
        return Objects.equals(inner, refType.inner);
    }


    @Override
    public Value defaultValue() {
        return new RefValue(inner, 0);
    }

    @Override
    public String toString() {
        return "Ref(" + inner + ")";
    }
}
