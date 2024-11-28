# 


# function: show_instructions
def show_instructions():
   #print a main menu and the commands
   print("\n" * 10)
   print("Pirate Ship Text Adventure Game")
   print("Collect 6 items to win the game, or be attacked by the Pirate.")
   print("Move commands: go South, go North, go East, go West")
   print("Add to Inventory: get 'item name'")
   print("-" * 20)
   input("Press Enter to continue...")

# function: show_game_menu
def show_game_menu(current_room, current_inventory, item_visible=''):
    #print the game menu and inventory
    print("-" * 20)
    print("You are in the", current_room)
    print(rooms[current_room])

    print("Inventory:", current_inventory)
    # display any items
    if item_visible:
      print("You see a", item_visible)
    print("-" * 20)

# function: move_to_room
def move_to_room(current_room, direction):
    # set next room to passed on in case no movement possible
    next_room = current_room

    # is the direction possible at the current room?
    if direction in rooms[current_room]:
        # move to the next room in the dictionary
        next_room = rooms[current_room][direction]

        # check if pirate was encountered
        try:
            if 'Pirate' in rooms[next_room]['item']:
                print("Oh no! You ran into the Pirate! Game over")
                next_room = 'exit'
        except Exception:
            pass
    else:
        print("Going {} is not possible".format(direction))
        return next_room

    # return to caller this room
    return next_room

# function: get_the_item
def get_the_item(current_room, current_inventory, selected_item):
    # set inventory list to passed on in case no items are added
    new_inventory = current_inventory
    try:
        # is the item in the inventory at the current room?
        if selected_item in rooms[current_room]['item']:
            # add item to inventory list
            new_inventory.append(selected_item)
            # remove from dictionary
            del rooms[current_room]['item']

    except Exception:
        print("{} not found".format(selected_item))

    # return to caller this inventory list
    return new_inventory

# -------------------------------------------------------------------
# dictionary linking a room to other rooms
rooms = {
    'Main Deck' : { 'south' : 'Lower Deck', 'north': 'Quarter Deck', 'east' : 'Galley', 'west' : 'Forecastle', 'item' : 'rope'},
    'Lower Deck' : { 'north' : 'Main Deck', 'east' : 'Cargo Hold', 'item' : 'key' },
    'Cargo Hold' : { 'west' : 'Lower Deck' },
    'Galley' : { 'north' : 'Great Cabin', 'west' : 'Main Deck', 'item' : 'bullets' },
    'Great Cabin' : { 'south' : 'Galley', 'item' : 'chest' },
    'Forecastle' : { 'east' : 'Main Deck', 'item' : 'Pirate' }, #villain
    'Quarter Deck' : { 'south' : 'Main Deck', 'east' : 'Mizzen Mast', 'item' : 'pistol' },
    'Mizzen Mast' : { 'west' : 'Quarter Deck', 'item' : 'sword' }
}

# -------------------------------------------------------------------
# game entry point
if __name__ == "__main__":

    # starting position
    current_room = 'Cargo Hold'
    # starting inventory is empty
    current_inventory = []

    # display instructions once before game loop
    show_instructions()

    print("\n" * 10)

    # main game loop
    while current_room != 'exit':
        # if there are any items in the current room, capture them in item_visible variable
        item_visible = ''
        if 'item' in rooms[current_room]:
            item_visible = rooms[current_room]['item']

        # check if all items collected
        if (len(current_inventory) == 6):
            print("You got all the items! You won!")
            current_room = 'exit'
            
        # otherwise keep looping gameplay
        else:
            # show game menu
            show_game_menu(current_room, current_inventory, item_visible)

            player_action, player_object = input('Enter a command:\n').lower().split()

            # check if player wants to exit
            if player_action == 'exit':
                current_room = 'exit'
                print("Thanks for playing!")

            # else if player wants to move to a room
            elif player_action == 'go':
                print("Direction: ", player_object)
                current_room = move_to_room(current_room, player_object)

            # else if player wants an item
            elif player_action == 'get':
                current_inventory = get_the_item(current_room, current_inventory, player_object)

            # else display the error
            else:
               print("{} is an invalid command".format(player_action))
   
