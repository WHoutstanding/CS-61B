public interface Deque<T> {
	/** 在items的前面添加item */
	public void addFirst(T item);

	/** 在items的后面添加item */
	public void addLast(T item);

	/** 判断items是否为空 */
	public boolean isEmpty();

	/** 返回items的大小 */
	public int size();

	/** 从前到后打印items的内容*/
	public void printDeque();

	/** 删除items的第一个item */
	public T removeFirst();

	/** 删除items的最后一个item */
	public T removeLast();

	/** 返回第index个item */
	public T get(int index);
}
