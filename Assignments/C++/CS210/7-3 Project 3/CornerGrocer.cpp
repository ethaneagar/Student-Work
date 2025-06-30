/**
 * Ethan Eagar
 * 06/22/2025
 */

#include <iostream>
#include <iomanip>
#include <string>
#include <fstream>
#include <map>

using namespace std;

/**
 * CLASS: GroceryInvetory
 */

class GroceryInvetory
{
private:
    // map to store item name and item count
    map<string, int> itemInventory;

    // filenames for IO
    string inputFilename;
    string outputFilename;

public:
    // constrcutor
    GroceryInvetory(const string& inputFilename, const string& outputFilename)
    {
        this->inputFilename = inputFilename;
        this->outputFilename = outputFilename;
    }

    // getFrequency() to get frequency of a specifc item
    int getFrequency(const string& itemName)
    {
        return itemInventory[itemName];
    }

    // getUserItemInput() to get display menu
    void displayGroceryMenu()
    {
        cout << "Grocer Data Menu:\n" << endl;
        cout << "\t1. Display the frequency of a specific item purchased." << endl;
        cout << "\t2. List the frequency of all items purchased." << endl;
        cout << "\t3. Display the histogram of all items purchased." << endl;
        cout << "\t4. Exit the program." << endl;
        cout << "\nPlease select an option: ";
    }

    // getUserItemInput() to get user search string
    string getUserItemInput()
    {
        string userSearchItem;
        system("cls");
        cout << "Enter the item to search: ";
        //getline(cin, userSearchItem);
        cin >> userSearchItem;
        return userSearchItem;
    }

    // getUserMenuInput() to get user menu choice
    int getUserMenuInput()
    {
        int userInput = 0;
        cin >> userInput;
        return userInput;
    }

    // displayFrequencies() to display frequencies of all items
    void displayFrequencies()
    {
        system("cls");
        //for (const auto& itemPair : itemInventory)
        for (const pair<const string, unsigned int> item : itemInventory)
        {
            cout << setw(20) << right << item.first << "  ";
            cout << string(item.second, '*') << endl;
        }
        cout << endl;
    }

    // displayHistogram() to display histogram of all items
    void displayHistogram()
    {
        ifstream readFromFS(outputFilename);
        string item;
        int itemQuantity;

        system("cls");

        // Check to see if file opened successfully
        if (!readFromFS.is_open())
        {
            cout << "Could not create file " << outputFilename << "." << endl;
        }

        readFromFS >> item;
        readFromFS >> itemQuantity;
        while (!readFromFS.fail())
        {
            cout << setw(20) << right << item << "  " << itemQuantity << endl;
            readFromFS >> item;
            readFromFS >> itemQuantity;
        }

        readFromFS.close();    // close file
        cout << endl;
    }

    // displayFrequency() to display frequency of searched item
    void displayFrequency(string searchItem)
    {
        cout << "The frequency of '" << searchItem << "' purchased is " << getFrequency(searchItem) << ".\n" << endl;
    }

    // readGroceryFile() to read from file and populate map
    void readGroceryFile()
    {
        string itemName;
        ifstream readFromFS(inputFilename);

        if (!readFromFS.is_open())
        {
            cout << "Could not open file " << inputFilename << "." << endl;
        }
        else
        {
            // read and count each item name and store count in map
            while (readFromFS >> itemName)
            {
                itemInventory[itemName]++;
            }

            readFromFS.close();    // close file
            cout << "File parsed successfully for " << inputFilename << ".\n" << endl;
        }
    }

    // writeOutputFile() to create output file
    void writeOutputFile()
    {
        ofstream writeToFS(outputFilename);

        if (!writeToFS.is_open())
        {
            cout << "Could not create file " << outputFilename << "." << endl;
        }
        else
        {
            // iterate through the map data pairs
            for (const auto& pair : itemInventory)
            {
                writeToFS << pair.first << " " << pair.second << endl;
            }

            writeToFS.close(); // close file
            cout << "Backup file created successfully as " << outputFilename << ".\n" << endl;
        }
    }
};  // end of class

/**
 * FUNCTION: main (entry point)
 *
 * loops menu for user choices and taking the appropriate action until the user chooses 4 for exit
 */
int main()
{
    // declare variables
    string inputFileName = "CS210_Project_Three_Input_File.txt";
    string outputFileName = "frequency.dat";
    string userSearchItem;
    GroceryInvetory grocerObj(inputFileName, outputFileName);
    int userMenuChoice;
    bool userWantsToExit = false;
    
    // get frequencies from original file
    grocerObj.readGroceryFile();

    // create initial save of the histogram file
    grocerObj.writeOutputFile();

    // main loop
    while (!userWantsToExit) 
    {
        grocerObj.displayGroceryMenu();
        userMenuChoice = grocerObj.getUserMenuInput();

        // determine user action       
        switch (userMenuChoice)
        {
            case 1: // user wants to select one Frequency
                userSearchItem = grocerObj.getUserItemInput();
                grocerObj.displayFrequency(userSearchItem);
                break; // end of case 1
            case 2: // user wants to see all Frequencies
                grocerObj.displayFrequencies();
                break; // end of case 2
            case 3: // user wants to display histrogram
                grocerObj.displayHistogram();
                break; // end of case 3
            case 4: // user wants to exit
                userWantsToExit = true;
                break; // end of case 4
            default:
                cout << "Invalid choice, please enter a number between 1 and 4." << endl;
                cin.clear();
        } // end of switch
    } // end of while user doesn't want to exit
    return 0;
}
