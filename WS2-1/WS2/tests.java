

import java.util.List;

public class tests implements Work {

	public int length (List a) {
		if (a.isEmpty())
			return 0;
		else if (a.tail.isEmpty())
			return 1;
		else
			return 1 + length(a.tail());
	}

}
