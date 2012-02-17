import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.Border;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Random;
import java.awt.event.*;

import java.awt.Dimension;

public class WordSandwich extends JApplet implements ActionListener 
{ 
  private JPanel guessPanel = new JPanel(new GridLayout(4,1));
  private JPanel guessTextEntryPanel = new JPanel(new FlowLayout());
  private JPanel hintPanel = new JPanel(new FlowLayout());
  private JLabel hintWord = new JLabel("Want a hint?");
  private JButton hintButton = new JButton("Give me a hint!");
  private JPanel mainPanel = new JPanel(new FlowLayout());
  private JTextField guessText = new JTextField(30);
  private JLabel topGuess = new JLabel("Upper Guess");
  private JButton guessButton = new JButton("Guess");
  private JLabel bottomGuess = new JLabel("Lower Guess");
  private JPanel wordPanel = new JPanel();
  private JLabel guesses = new JLabel("Guesses Go Here");
  private String currentWord;
  private String upperWord;
  private String lowerWord;

  
  ArrayList<String> dictionary = new ArrayList<String>();
  ArrayList<String> guessList = new ArrayList<String>();
  public void init()
  {
	 this.guessButton.addActionListener(this);
	 this.hintButton.addActionListener(this);
	 
   this.mainPanel.setPreferredSize(new Dimension(640,400));
	 this.topGuess.setBorder(BorderFactory.createLineBorder(Color.black));
	 this.bottomGuess.setBorder(BorderFactory.createLineBorder(Color.black));
	 this.guessText.setBorder(BorderFactory.createLineBorder(Color.black));
	 
	 this.guessTextEntryPanel.add(guessText);
	 this.guessTextEntryPanel.add(guessButton);
	 this.hintPanel.add(hintWord);
	 this.hintPanel.add(hintButton);
	 this.guessPanel.add(topGuess);
	 this.guessPanel.add(guessTextEntryPanel);
	 this.guessPanel.add(bottomGuess);
	 this.guessPanel.add(hintPanel);
	 this.mainPanel.add(guessPanel);
	 
	 this.wordPanel.setPreferredSize(new Dimension(160,400));
	 this.wordPanel.setBorder(BorderFactory.createLineBorder(Color.black));
	 this.wordPanel.add(guesses);
	 this.mainPanel.add(wordPanel);
	 getContentPane().add(mainPanel);
	 loadDictionary("./dictionary.dat");
	 pickWord();
  }
  
  private void loadDictionary(String path)
  {
    BufferedReader buffReader = null;
    try
	  {
      buffReader = new BufferedReader (new FileReader(path));
      String line = buffReader.readLine();
      while(line != null)
      {
        dictionary.add(line);
        line = buffReader.readLine();
      }
	  }
	  catch(IOException ioe)
    {
      ioe.printStackTrace();
    }
	  finally
  	{
	    try
	    {
        buffReader.close();
	  	}
	    catch(IOException ioe1)
	    {
				//Leave It
		  }
  	}
  }
  
  public void pickWord()
  {
    Random rand = new Random(System.currentTimeMillis());
    currentWord = dictionary.get(rand.nextInt(dictionary.size()));
    //Printing word for testing/debugging purposes, delete after
    System.out.println(currentWord);
  }
  
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource().equals(guessButton))
    {
      compareWord(guessText.getText());
      guessText.setText("");
    }
    else if(e.getSource().equals(hintButton))
    {
      hintWord.setText(getHint());
    }
  }
  
  public void compareWord(String word)
  {
    word = word.toUpperCase();
    int wordDifference = word.compareTo(this.currentWord);
    if(wordDifference == 0)
    {
      JOptionPane.showMessageDialog(this,"WE HAVE A MATCH!");
    }
    else if(wordDifference < 0)
    {
      System.out.println("Higher");
       topGuess.setText(word);
    }
    else //(WordDifference > 0)
    {
      System.out.println("Lower");
      bottomGuess.setText(word);
    }
    guessList.add(word);
    updateGuessedWords();
    this.repaint();
  }
  
  private void updateGuessedWords()
  {
    String words = "<html>"; 
    for(int index = 0; index < guessList.size(); index++)
    {
      words += guessList.get(index) + "<br>";
    }
    words += "</html>";
    this.guesses.setText(words);
  }
  
  private String getHint()
  {
    String guess;
    if(topGuess.getText() != "Upper Guess")
    {
      guess = topGuess.getText();
      return Searcher.binarySearchHint(this.currentWord, guess , dictionary);
    }
    else if(topGuess.getText() != "Lower Guess")
    {
      guess = topGuess.getText();
      return Searcher.binarySearchHint(this.currentWord, guess , dictionary);
    }
    else
    {
      return "Guess a word first!";
    }
    
    
  }
}
