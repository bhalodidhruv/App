import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;


public class PuttingIntoPractice{
    public static void main(String ...args){    
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );	
        
        List<Transaction> Trans2011 = transactions.stream().filter(trans -> trans.getYear() == 2011 )
        		.sorted(comparing(Transaction::getValue)).collect(toList());
        System.out.println(Trans2011);
        
        List<String> UniqueCities = transactions.stream().
        							map(tran -> tran.getTrader().getCity()).distinct().
        							collect(toList());
        System.out.println(UniqueCities);
        
        List<Trader> cambTrader = transactions.stream().
        						  map(tran -> tran.getTrader() ).filter(trad -> trad.getCity() == "Cambridge")
        						  .sorted(comparing(Trader::getName)).distinct().collect(toList());
        System.out.println(cambTrader); 
        
        String alltradernames = transactions.stream().map(tran -> tran.getTrader().getName())
        						.sorted().distinct().reduce("", String::concat);
        System.out.println(alltradernames);
        
        Boolean traderMilan = transactions.stream().map(tran -> tran.getTrader().getCity()).
        					  anyMatch(x -> x == "Milan");
        System.out.println(traderMilan);
        
        List<Integer> transvalues = transactions.stream().filter(tran -> tran.getTrader().getCity() == "Cambridge")
        						.map(x -> x.getValue()).collect(toList());
        System.out.println(transvalues);
        
        Optional<Integer> highval = transactions.stream().map(tran -> tran.getValue()).max((p1, p2) -> Integer.compare( p1, p2));
        System.out.println(highval);
        
        Transaction smalltran = transactions.stream().min((p1, p2) -> Integer.compare( p1.getValue(), p2.getValue()))
                .get();
        System.out.println(smalltran);
        
        List<Long> lowercase = transactions.stream().map(tran -> tran.getTrader().getName()).distinct()
        						  .map(y -> {
        							  return y.codePoints().filter(c-> c>='a' && c<='z').count();
        						  }).collect(toList());
        System.out.println("<<<<<<<" + lowercase);
        
        String cityLarge = transactions.stream().map(tran -> tran.getTrader().getCity())
			        		.distinct()
			        		 .max( Comparator.comparing( y -> y.codePoints().filter(c-> c>='a' && c<='z').count() ) ).get();
        System.out.println(cityLarge);		
        List<Integer> myList = Arrays.asList(0,1);
        Stream.iterate(myList, p -> new ArrayList<Integer>(Arrays.asList(p.get(1), (p.get(0) + p.get(1)))))
        .limit(20)
        .forEach(t -> System.out.println(t));
    }
}