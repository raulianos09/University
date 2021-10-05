
package Model.Type;

import Model.Value.StringValue;
import Model.Value.Value;

public class StringType implements Type {

    @Override
    public Value defaultValue() {
        return new StringValue("");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }

    @Override
    public String toString() {
        return "string";
    }


}