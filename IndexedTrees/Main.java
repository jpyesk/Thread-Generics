package IndexedTrees;

public class Main
{
	public static void main(String[] args)
	{
		var tree = new Inner<Integer>(
				new Inner<Integer>(
						new Leaf<Integer>(1),
						new Leaf<Integer>(2)
				),
				new Leaf<Integer>(3)
		);

		//var t = (Inner<Integer>)tree.left;

        RunTests();
	}

	public static void RunTests()
	{
        CheckInnerSize();
		CheckInnerInsert();
	}

	public static void CheckInnerInsert()
	{
		var tree = new Inner<Integer>(
							new Inner<Integer>(
									new Leaf<Integer>(1),
									new Inner<Integer>(
											new Leaf<Integer>(2),
											new Leaf<Integer>(3)
									)
							),
							new Inner<Integer>(
									new Inner<Integer>(
											new Leaf<Integer>(4),
											new Leaf<Integer>(5)
									),
									new Leaf<Integer>(6)
							)
					);
		Check(tree.get(0), 1, "CheckInnerInsert");
		Check(tree.get(1), 2, "CheckInnerInsert");
		Check(tree.get(2), 3, "CheckInnerInsert");
		Check(tree.get(3), 4, "CheckInnerInsert");
		Check(tree.get(4), 5, "CheckInnerInsert");
		Check(tree.get(5), 6, "CheckInnerInsert");
	}

	public static void Check(int actual, int result, String testName)
	{
		System.out.println(testName + ": actual: " + actual + " result: " + result + " " + (actual == result));
	}

    public static void CheckInnerSize()
    {
        var tree = new Inner<Integer>(
						new Inner<Integer>(
								new Leaf<Integer>(1),
								new Leaf<Integer>(2)
						),
						new Leaf<Integer>(3)
				);

        Check(3, tree.size(), "CheckInnerSize");
    }
}
