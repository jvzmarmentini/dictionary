import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ChainHashMap
 * 
 * Desenvolva uma classe ChainHashMap de dicionário simples capaz de armazenar
 * pares (chave, valor) e resolver conflitos através de encadeamento. Para
 * simplificar a tarefa, você deve considerar que as chaves e os valores serão
 * do tipo String. Use o método hashCode padrão de Java para calcular o valor de
 * hash de cada String chave. A sua classe deve ser responsável pela etapa de
 * compressão. Cada bucket do dicionário deve ser modelado como um Arraylist. O
 * seu dicionário deve prover métodos para contar o número de colisões e também
 * retornar o fator de carga do dicionário a qualquer instante. O método
 * construtor recebe como argumento o número inicial de buckets. Em caso de
 * inserção de chaves repetidas, o dicionário deve apenas atualizar o valor
 * associado à chave. A sua classe deve obedecer à interface Map e estender
 * classe abstrata AbstractMap. Ambos arquivos estão em anexo.
 */
public class ChainHashMap extends AbstractMap {
    int initialSize = 16;
    double loadFactor = .75;
    double capacity = initialSize * loadFactor;
    int size = 0;

    ArrayList<MapEntry>[] chainHashMap = new ArrayList[initialSize];

    public ChainHashMap() {
        for (int i = 0; i < initialSize; i++) {
            chainHashMap[i] = new ArrayList<MapEntry>();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(Object key) {
        int bucket = key.hashCode() % (initialSize - 1);
        for (MapEntry foo : chainHashMap[bucket]) {
            if (foo.getKey().equals(key)) {
                return foo.getValue();
            }
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        MapEntry entry = new MapEntry(key, value);
        int bucket = entry.getKey().hashCode() % (initialSize - 1);

        for (MapEntry foo : chainHashMap[bucket]) {
            if (foo.getKey().equals(entry.getKey())) {
                Object old = foo.getValue();
                foo.setValue(entry.getValue());
                return old;
            }
        }
        chainHashMap[bucket].add(entry);

        size++;
        return null;
    }

    @Override
    public Object remove(Object key) {
        int bucket = key.hashCode() % (initialSize - 1);
        for (MapEntry foo : chainHashMap[bucket]) {
            if (foo.getKey().equals(key)) {
                Object old = foo.getValue();
                chainHashMap[bucket].remove(foo);
                size--;
                return old;
            }
        }

        return null;
    }

    @Override
    public Iterable keySet() {
        List<Object> values = new ArrayList<Object>();

        for (ArrayList<MapEntry> arrayList : chainHashMap) {
            if (!arrayList.isEmpty()) {
                for (MapEntry mapEntry : arrayList) {
                    values.add(mapEntry.getKey());
                }
            }
        }

        return values;
    }

    @Override
    public Iterable values() {
        List<Object> values = new ArrayList<Object>();

        for (ArrayList<MapEntry> arrayList : chainHashMap) {
            if (!arrayList.isEmpty()) {
                for (MapEntry mapEntry : arrayList) {
                    values.add(mapEntry.getValue());
                }
            }
        }

        return values;
    }

    @Override
    public Iterable entrySet() {
        List<Object> entries = new ArrayList<Object>();

        for (ArrayList<MapEntry> arrayList : chainHashMap) {
            if (!arrayList.isEmpty()) {
                entries.add(arrayList);
            }
        }

        return entries;
    }

    @Override
    public String toString() {
        return "ChainHashMap [capacity=" + capacity + ", chainHashMap=" + Arrays.toString(chainHashMap)
                + ", initialSize=" + initialSize + ", loadFactor=" + loadFactor + "]";
    }

}