public class LinearProbingHash<Key> {

    Key[] table;
    int size;
    int numberoffull; // number of full elements
    double loadlimit = 0.5;

    public LinearProbingHash(int size) {
        table = (Key[]) new Object[size];
        this.size = size;
    }


    public int hash(Key t) {
        return ((t.hashCode() & 0x7fffffff) % size); //will result in a positive integer.(all 1 except the sign bit.)
    }

    public double loadFactor() {
        return (double) (numberoffull / size);
    }

    public void resize(int capasity) {
        LinearProbingHash<String> h = new LinearProbingHash<>(capasity);
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                h.insert(table[i].toString());
            }
        }
        size = capasity;
        numberoffull = h.numberoffull;
        table = (Key[]) h.table;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        if (!contains(key)) {
            return;
        }

        int index = hash(key);
        while (!key.equals(table[index])) {
            index = (index + 1) % size;
        }

        table[index] = null;
        numberoffull--;
        //rehash
        index = (index + 1) % size;
        while (table[index] != null) {
            Key keyToRehash = table[index];
            table[index] = null;
            numberoffull--;
            insert(keyToRehash);
            index = (index + 1) % size;
        }

        if (numberoffull > 0 && numberoffull <= size / 8) { //loadlimit 0.125
            resize(size / 2);
        }

    }



    public boolean insert2(Key key) {
        int i;
        int h = hash(key);
        System.out.print(" hash: " + h);
        for (i = h; table[i] != null; i = (i + 1) % size) {
            if (table[i].equals(key)) {
                return true;
            }
            if (i + 1 == h) {
                return false; // table is full
            }
        }
        table[i] = key;
        numberoffull++; // increase number of stored items
        return true;
    }

    //contains method returns true if hash map contains the Key
    public boolean contains(Key key) {
        int ix = hash(key);
        System.out.print(" hash : " + ix);
        int startIx = ix;

        while (table[ix] != null && (ix + 1 != startIx)) {
            if (table[ix].equals(key)) {
                return true; //found
            }            //if (ix + 1 == startIx) return false; // starting point
            ix = (ix + 1) % size; // cycle through
            //System.out.print(" ix : " + ix);
        }
        return false;
    }

    public void quadraticProb(Key key){
        int ix = hash(key);
        int i = ix, h = 1;
        do{
            if(table[i] == null){
                table[i] = key;
                numberoffull++;
                return;
            }
            if(table[i].equals(key)){
                return;
            }
            i = (i + h * h++) % size;
        }while(i != ix);
    }

    public Key searchQuadratic(Key key){
        int ix = hash(key);
        int h = 1;
        while(table[ix] != null){
            if (table[ix].equals(key)){
                return table[ix];
            }
            ix = (ix + h * h++) % size;
            System.out.println("Index: "+ix);//optinal
        }
        return null;
    }

    public int hash2(Key key){
        return (7 - (key.hashCode() % 7));
    }
    
    public boolean insert(Key key) {
        int ix = hash(key);
        System.out.print(" hash : " + ix);
        // must check for a whole cycle there can be infinite loop
        if (numberoffull == size) {
            System.out.println(" : The table is full! \n");
            return false;
        }

        while (table[ix] != null) {
            if (table[ix].equals(key)) {
                System.out.println(" : Table has the key");
                return false;
            }
            ix = (ix + 1) % size;
        }
        // if table[ix]==null this means it is empty. Insert.
        table[ix] = key;
        numberoffull++;
        return true;
    }
    public boolean doubleHashInsert(Key key) {
        int ix = hash(key);
        System.out.print(" hash : " + ix);
        // must check for a whole cycle there can be infinite loop
        if (numberoffull == size) {
            System.out.println(" : The table is full! \n");
            return false;
        }
        if (table[ix] != null && !table[ix].equals(key)){
            int ix2 = hash2(key);
            int i = 1;
            while(true){
                int newIndex = (ix + i * ix2) % size;
                if(table[newIndex] == null){
                    table[newIndex] = key;
                    break;
                }
                i++;
            }
        }
        else{
            table[ix] = key;
        }
        numberoffull++;
        return true;
    }

    public boolean searchDoubleHash(Key key){
        int ix = hash(key);
        int ix2 = hash2(key);
        int i = 0;
        while(table[(ix + i * ix2) % size] != key){
            if(table[(ix + i * ix2) % size] == null){
                return false;
            }
            i++;
        }
        return true;
    }

    public String toString() {
        String s = "[";
        for (int i = 0; i < size; i++) {
            s += table[i] + ",";
        }
        return s + "]";
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinearProbingHash<String> h0 = new LinearProbingHash<>(5);
        h0.insert("boray");
        System.out.println(h0);
        h0.insert("berke");
        System.out.println(h0);
        h0.insert("ali");
        System.out.println(h0);
        h0.insert("ayşe");
        System.out.println(h0);
        h0.insert("Boray");
        System.out.println(h0);

        LinearProbingHash<Integer> h1 = new LinearProbingHash<>(7);
        java.util.Random random = new java.util.Random(0);
        for (int i = 1; i < 9; i++) {
            Integer key = random.nextInt(100);
            System.out.print("Key " + key);
            boolean success = h1.insert(key);
            System.out.println(" ==> Table: " + h1);
        }
        int searchKey = 90;
        System.out.print("Searching " + searchKey);
        System.out.println(" " + h1.contains(searchKey));

    }
}
