package fun.hydropixel.skyblock.data.impl;

import fun.hydropixel.skyblock.data.Datapoint;

public class DatapointDouble extends Datapoint<Double> {
    public DatapointDouble(String key, Double value) {
        super(key, value, new GsonSerializer<>(Double.class));
    }

    @Override
    public Datapoint<Double> deepClone() {
        return new DatapointDouble(key, serializer.clone(value));
    }
}
