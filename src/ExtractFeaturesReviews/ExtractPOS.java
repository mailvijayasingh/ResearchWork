package ExtractFeaturesReviews;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.util.PropertiesUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import ReadJsonFilesReviews.readTextLines;
import edu.stanford.nlp.io.*;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.util.*;
public class ExtractPOS {

	public static void main (String[] args)throws IOException
	{
		readTextLines readFile = new readTextLines();
	
		JSONOutputter jo = new JSONOutputter();
		PrintWriter out = new PrintWriter(System.out);
		StanfordCoreNLP pipeline = new StanfordCoreNLP(
				PropertiesUtils.asProperties(
						"annotators", "tokenize, ssplit, pos, lemma, ner"));

		// read some text in the text variable
		String text = "My name is Vijaya Singh";

		// create an empty Annotation just with the given text
		Annotation document = new Annotation(text);

		// run all Annotators on this text
		pipeline.annotate(document);
		List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
	    if (sentences != null && sentences.size() > 0) {
	      CoreMap sentence = sentences.get(0);
	      Tree tree = sentence.get(TreeCoreAnnotations.TreeAnnotation.class);
	      out.println();
	      out.println("The first sentence parsed is:");
//	      tree.pennPrint(out);
	      String str =jo.jsonPrint(document);
	      System.out.println(str);
	    }
		
		
	}
	
	
	
}
