package OmerNof;

import java.io.Serializable;
import java.util.ArrayList;

public class Doctor extends Lecturer implements Serializable {
    protected ArrayList<String> articles;

    public Doctor(String name, int id, Degree typeOfDegree, String nameOfDegree, double salary, String department) {
        super(name, id, typeOfDegree, nameOfDegree, salary, department);
        this.articles = new ArrayList<>();
    }

    public static int compare(Doctor d1, Doctor d2) {
        if (d1.getNumOfArticles() < d2.getNumOfArticles())
            return -1;
        else if (d1.getNumOfArticles() > d2.getNumOfArticles())
            return 1;
        else
            return 0;
    }

    public void addArticle(String articleTitle) {
        articles.add(articleTitle);
    }

    public ArrayList<String> getArticles() {
        return articles;
    }

    @Override
    public int getNumOfArticles() {
        return articles.size();
    }

    public void setArticles(ArrayList<String> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return super.toString() + ", articles=" + articles.size();
    }
}
