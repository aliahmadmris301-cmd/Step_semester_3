abstract class Question{
    protected String question;
    protected String correctAnswer;
    protected int points;
    Question(String question,String correctAnswer,int points){
        this.question=question;
        this.correctAnswer=correctAnswer;
        this.points=points;
    }
    abstract int evaluate(String answer);
}
class MultipleChoiceQuestion extends Question{
    MultipleChoiceQuestion(String question,String correctAnswer,int points){
        super(question,correctAnswer,points);
    }
    int evaluate(String answer){
        if(answer.equals(correctAnswer)){
            return points;
        }
        return 0;
    }
}
class TrueFalseQuestion extends Question{
    TrueFalseQuestion(String question,String correctAnswer,int points){
        super(question,correctAnswer,points);
    }
    int evaluate(String answer){
        if(answer.equals(correctAnswer)){
            return points;
        }
        return 0;
    }
}
class Attempt{
    private boolean submitted;
    Attempt(){
        submitted=false;
    }
    void answerQuestion(Question q,String answer){
        if (submitted){
            System.out.println("Cannot change answers for a submitted examination.");
            return;
        }
        int marks=q.evaluate(answer);
        if(marks>0){
            System.out.println("Answer recorded. Correct (" + marks + " points)");
        }else{
            System.out.println("Answer recorded. Incorrect (0 points)");
        }
    }
    void submit(){
        submitted=true;
        System.out.println("Examination submitted.");
    }
}
public class OnlineExaminationSystem{
    public static void main(String[] args){
        MultipleChoiceQuestion q1=new MultipleChoiceQuestion("Which is a programming language?","C",5);
        TrueFalseQuestion q2 =new TrueFalseQuestion("Java is an OOP language.","True",5);
        Attempt attempt=new Attempt();
        System.out.println("Exam started.");
        attempt.answerQuestion(q1, "C");
        attempt.answerQuestion(q2, "False");
        attempt.submit();
        attempt.answerQuestion(q1, "Java");
    }
}