public class Tester
{
  private static int errors;
  
  public static void main(String[] args)
  {
    errors = 0;
    
    test("contains", "empty", !Lab.contains(null, "empty"));
      
    ListNode<String> stringList = makeList("first", "middle", "last");
    
    test("contains", "first", Lab.contains(stringList, "first"));
    test("contains", "middle", Lab.contains(stringList, "middle"));
    test("contains", "last", Lab.contains(stringList, "last"));
    test("contains", "not in list", !Lab.contains(stringList, "not in list"));
    
    test("min", "first", Lab.min(makeList(-5, 80, 4)) == -5);
    test("min", "middle", Lab.min(makeList(80, -5, 4)) == -5);
    test("min", "last", Lab.min(makeList(4, 80, -5)) == -5);
    test("min", "only", Lab.min(new ListNode<Integer>(-5, null)) == -5);
    
    test("set", "first", Lab.set(stringList, 0, "new").equals("first")
           && match(stringList, "new middle last"));
    test("set", "middle", Lab.set(stringList, 1, "change").equals("middle")
           && match(stringList, "new change last"));
    test("set", "last", Lab.set(stringList, 2, "alter").equals("last")
           && match(stringList, "new change alter"));

    test("build", "empty", Lab.build(0, "a") == null);
    test("build", "1 element", match(Lab.build(1, "a"), "a"));
    test("build", "many elements", match(Lab.build(4, "b"), "b b b b"));
    
    test("toLinkedList", "empty", Lab.toLinkedList(new int[] {}) == null);
    test("toLinkedList", "1 element", match(Lab.toLinkedList(new int[] {7}), "7"));
    test("toLinkedList", "many elements",
           match(Lab.toLinkedList(new int[] {4, 5, 2}), "4 5 2"));
    
    ListNode<String> addList;
    addList = new ListNode<String>("a", null);
    test("add", "1 element, new", Lab.add(addList, "b") && match(addList, "a b"));
    addList = new ListNode<String>("a", null);
    test("add", "1 element, duplicate", !Lab.add(addList, "a") && match(addList, "a"));
    addList = makeList("a", "b", "c");
    test("add", "many elements, new", Lab.add(addList, "d") && match(addList, "a b c d"));
    addList = makeList("a", "b", "c");
    test("add", "duplicate of first", !Lab.add(addList, "a") && match(addList, "a b c"));
    addList = makeList("a", "b", "c");
    test("add", "duplicate of middle", !Lab.add(addList, "b") && match(addList, "a b c"));
    addList = makeList("a", "b", "c");
    test("add", "duplicate of last", !Lab.add(addList, "c") && match(addList, "a b c"));
    
    ListNode<String> removeList;
    removeList = new ListNode<String>("a", null);
    test("removeAll", "1 element, not there", match(Lab.removeAll(removeList, "b"), "a"));
    removeList = new ListNode<String>("a", null);
    test("removeAll", "1 element, present", Lab.removeAll(removeList, "a") == null);
    removeList = makeList("a", "b", "c");
    test("removeAll", "multiple elements, not there",
         match(Lab.removeAll(removeList, "d"), "a b c"));
    removeList = makeList("a", "b", "c", "d", "e");
    test("removeAll", "first", match(Lab.removeAll(removeList, "a"), "b c d e"));
    removeList = makeList("a", "b", "c", "d", "e");
    test("removeAll", "middle", match(Lab.removeAll(removeList, "c"), "a b d e"));
    removeList = makeList("a", "b", "c", "d", "e");
    test("removeAll", "middle", match(Lab.removeAll(removeList, "e"), "a b c d"));
    removeList = makeList("a", "b", "c", "b", "e");
    test("removeAll", "duplicate in middle", match(Lab.removeAll(removeList, "b"), "a c e"));
    removeList = makeList("a", "b", "c", "d", "b");
    test("removeAll", "duplicate at end", match(Lab.removeAll(removeList, "b"), "a c d"));
    removeList = makeList("a", "b", "c", "c", "d");
    test("removeAll", "consecutive middle", match(Lab.removeAll(removeList, "c"), "a b d"));
    removeList = makeList("a", "b", "c", "d", "d");
    test("removeAll", "consecutive end", match(Lab.removeAll(removeList, "d"), "a b c"));
    removeList = makeList("a", "b", "c", "a", "d");
    test("removeAll", "duplicate at front", match(Lab.removeAll(removeList, "a"), "b c d"));
    removeList = makeList("a", "a", "b", "c", "d");
    test("removeAll", "consecutive front", match(Lab.removeAll(removeList, "a"), "b c d"));
    removeList = makeList("a", "a", "a", "b", "a");
    test("removeAll", "3 in front", match(Lab.removeAll(removeList, "a"), "b"));
    removeList = makeList("a", "a", "a", "a", "a");
    test("removeAll", "all same", match(Lab.removeAll(removeList, "a"), ""));
    
    test("insert", "empty", match(Lab.insert(null, 5), "5"));
    ListNode<Integer> insertList = new ListNode<Integer>(5, null);
    test("insert", "1, before", match(Lab.insert(insertList, 3), "3 5"));
    insertList = new ListNode<Integer>(5, null);
    test("insert", "1, after", match(Lab.insert(insertList, 6), "5 6"));
    insertList = new ListNode<Integer>(5, null);
    test("insert", "1, same", match(Lab.insert(insertList, 5), "5 5"));
    insertList = makeList(10, 20, 30, 40, 50);
    test("insert", "many, before", match(Lab.insert(insertList, 5), "5 10 20 30 40 50"));
    insertList = makeList(10, 20, 30, 40, 50);
    test("insert", "many, second", match(Lab.insert(insertList, 15), "10 15 20 30 40 50"));
    insertList = makeList(10, 20, 30, 40, 50);
    test("insert", "many, before last", match(Lab.insert(insertList, 45), "10 20 30 40 45 50"));
    insertList = makeList(10, 20, 30, 40, 50);
    test("insert", "many, after", match(Lab.insert(insertList, 83), "10 20 30 40 50 83"));
    insertList = makeList(10, 20, 30, 40, 50);
    test("insert", "dup first", match(Lab.insert(insertList, 10), "10 10 20 30 40 50"));
    insertList = makeList(10, 20, 30, 40, 50);
    test("insert", "dup middle", match(Lab.insert(insertList, 30), "10 20 30 30 40 50"));
    insertList = makeList(10, 20, 30, 40, 50);
    test("insert", "dup last", match(Lab.insert(insertList, 50), "10 20 30 40 50 50"));
    
    if (errors == 0)
      System.out.println("You win!!!");
    else
      System.out.println("Did not pass " + errors + " test cases");
  }
  
  public static void test(String method, String testCase, boolean exp)
  {
    if (!exp)
    {
      System.out.println(method + " FAILS for case " + testCase);
      errors++;
    }
    else
    {
      System.out.println(method + " passed case " + testCase);
    }
  }
  
  public static <E> ListNode<E> makeList(E first, E second, E third)
  {
    return new ListNode<E>(first, new ListNode<E>(second, new ListNode<E>(third, null)));
  }
  
  public static <E> ListNode<E> makeList(E first, E second, E third, E fourth, E fifth)
  {
    return new ListNode<E>(first, new ListNode<E>(second, makeList(third, fourth, fifth)));
  }

  public static <E> String toString(ListNode<E> list)
  {
    String s = "";
    while (list != null)
    {
      s += list.getValue() + " ";
      list = list.getNext();
    }
    return s.trim();
  }
  
  public static <E> boolean match(ListNode<E> list, String display)
  {
    return toString(list).equals(display);
  }
}