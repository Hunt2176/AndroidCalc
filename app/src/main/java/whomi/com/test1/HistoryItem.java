package whomi.com.test1;

public class HistoryItem {
    private String Eq;
    private Double Answer;
    private String FullEq = "";

    HistoryItem(String Eq,Double Answer){
        this.Eq = Eq;
        this.Answer = Answer;
    }

    HistoryItem(String fullEq){
        this.FullEq = fullEq;
    }


    String getContent(){
        if (!this.FullEq.isEmpty()){
            return this.FullEq;
        }
        return this.Eq + "=" + this.Answer;
    }
}
