package kontaktmngr.model;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import kontaktmngr.dal.AdressListLoader;

public class AdressList implements ObservableList<Adress>
{
	//Field used to cache the list once it was retrieved.
	private ObservableList<Adress> _originalList = null;
	private final int _personId;
	
	public AdressList(int personId)
	{
		_personId = personId;
	}
	
	private ObservableList<Adress> getOriginalList()
	{
		if (_originalList == null)
			_originalList = AdressListLoader.getInstance().get(_personId);
		
		return _originalList;
	}

	public boolean add(Adress arg0)
	{
		return getOriginalList().add(arg0);
	}

	public void add(int arg0, Adress arg1)
	{
		getOriginalList().add(arg0, arg1);
	}

	public boolean addAll(Adress... arg0)
	{
		return getOriginalList().addAll(arg0);
	}

	public boolean addAll(Collection<? extends Adress> arg0)
	{
		return getOriginalList().addAll(arg0);
	}

	public boolean addAll(int arg0, Collection<? extends Adress> arg1)
	{
		return getOriginalList().addAll(arg0, arg1);
	}

	public void addListener(InvalidationListener arg0)
	{
		getOriginalList().addListener(arg0);
	}

	public void addListener(ListChangeListener<? super Adress> arg0)
	{
		getOriginalList().addListener(arg0);
	}

	public void clear()
	{
		getOriginalList().clear();
	}

	public boolean contains(Object arg0)
	{
		return getOriginalList().contains(arg0);
	}

	public boolean containsAll(Collection<?> arg0)
	{
		return getOriginalList().containsAll(arg0);
	}

	public boolean equals(Object arg0)
	{
		return getOriginalList().equals(arg0);
	}

	public FilteredList<Adress> filtered(Predicate<Adress> arg0)
	{
		return getOriginalList().filtered(arg0);
	}

	public void forEach(Consumer<? super Adress> arg0)
	{
		getOriginalList().forEach(arg0);
	}

	public Adress get(int arg0)
	{
		return getOriginalList().get(arg0);
	}

	public int hashCode()
	{
		return getOriginalList().hashCode();
	}

	public int indexOf(Object arg0)
	{
		return getOriginalList().indexOf(arg0);
	}

	public boolean isEmpty()
	{
		return getOriginalList().isEmpty();
	}

	public Iterator<Adress> iterator()
	{
		return getOriginalList().iterator();
	}

	public int lastIndexOf(Object arg0)
	{
		return getOriginalList().lastIndexOf(arg0);
	}

	public ListIterator<Adress> listIterator()
	{
		return getOriginalList().listIterator();
	}

	public ListIterator<Adress> listIterator(int arg0)
	{
		return getOriginalList().listIterator(arg0);
	}

	public Stream<Adress> parallelStream()
	{
		return getOriginalList().parallelStream();
	}

	public void remove(int arg0, int arg1)
	{
		getOriginalList().remove(arg0, arg1);
	}

	public Adress remove(int arg0)
	{
		return getOriginalList().remove(arg0);
	}

	public boolean remove(Object arg0)
	{
		return getOriginalList().remove(arg0);
	}

	public boolean removeAll(Adress... arg0)
	{
		return getOriginalList().removeAll(arg0);
	}

	public boolean removeAll(Collection<?> arg0)
	{
		return getOriginalList().removeAll(arg0);
	}

	public boolean removeIf(Predicate<? super Adress> arg0)
	{
		return getOriginalList().removeIf(arg0);
	}

	public void removeListener(InvalidationListener arg0)
	{
		getOriginalList().removeListener(arg0);
	}

	public void removeListener(ListChangeListener<? super Adress> arg0)
	{
		getOriginalList().removeListener(arg0);
	}

	public void replaceAll(UnaryOperator<Adress> arg0)
	{
		getOriginalList().replaceAll(arg0);
	}

	public boolean retainAll(Adress... arg0)
	{
		return getOriginalList().retainAll(arg0);
	}

	public boolean retainAll(Collection<?> arg0)
	{
		return getOriginalList().retainAll(arg0);
	}

	public Adress set(int arg0, Adress arg1)
	{
		return getOriginalList().set(arg0, arg1);
	}

	public boolean setAll(Adress... arg0)
	{
		return getOriginalList().setAll(arg0);
	}

	public boolean setAll(Collection<? extends Adress> arg0)
	{
		return getOriginalList().setAll(arg0);
	}

	public int size()
	{
		return getOriginalList().size();
	}

	public void sort(Comparator<? super Adress> arg0)
	{
		getOriginalList().sort(arg0);
	}

	public SortedList<Adress> sorted()
	{
		return getOriginalList().sorted();
	}

	public SortedList<Adress> sorted(Comparator<Adress> arg0)
	{
		return getOriginalList().sorted(arg0);
	}

	public Spliterator<Adress> spliterator()
	{
		return getOriginalList().spliterator();
	}

	public Stream<Adress> stream()
	{
		return getOriginalList().stream();
	}

	public List<Adress> subList(int arg0, int arg1)
	{
		return getOriginalList().subList(arg0, arg1);
	}

	public Object[] toArray()
	{
		return getOriginalList().toArray();
	}

	public <T> T[] toArray(T[] arg0)
	{
		return getOriginalList().toArray(arg0);
	}
}
