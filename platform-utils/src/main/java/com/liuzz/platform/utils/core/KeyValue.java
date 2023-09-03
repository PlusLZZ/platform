package com.liuzz.platform.utils.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 键值对对象
 * @param <K>
 * @param <V>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeyValue<K,V> {

    private K key;

    private V value;

}
