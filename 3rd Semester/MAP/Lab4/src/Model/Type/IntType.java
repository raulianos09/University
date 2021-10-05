package Model.Type;

import Model.Value.Value;
import Model.Value.IntValue;

public class IntType implements Type{
    @Override
    public boolean equals(Object other)
    {
        return other instanceof IntType;
    }

    @Override
    public String toString()
    {
        return "int";
    }

    @Override
    public Value defaultValue() {
        return new IntValue(0);
    }
}
