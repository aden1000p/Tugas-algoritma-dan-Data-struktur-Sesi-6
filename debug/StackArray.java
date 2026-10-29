import java.util.Arrays;

public class StackArray {
    private final int[] items;
    private int top;

    public StackArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Kapasitas stack harus lebih dari 0.");
        }
        items = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new IllegalStateException("Stack penuh.");
        }
        items[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack kosong.");
        }
        return items[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack kosong.");
        }
        return items[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean empty() {
        return isEmpty();
    }

    public boolean isFull() {
        return top == items.length - 1;
    }

    public int size() {
        return top + 1;
    }

    public int search(int value) {
        for (int index = top; index >= 0; index--) {
            if (items[index] == value) {
                return top - index + 1;
            }
        }
        return -1;
    }

    public void display() {
        System.out.println(Arrays.toString(Arrays.copyOf(items, size())));
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.print("Isi stack: ");
        stack.display();

        System.out.println("Nilai teratas (peek): " + stack.peek());
        System.out.println("Posisi 10 dari atas (search): " + stack.search(10));
        System.out.println("Jumlah elemen (size): " + stack.size());
        System.out.println("Stack kosong (empty): " + stack.empty());
        System.out.println("Ambil elemen teratas (pop): " + stack.pop());
        System.out.print("Isi stack setelah pop: ");
        stack.display();
    }
}
