# Note to Self - Kotlin App

Welcome to **Note to Self**, a simple and intuitive note-taking app built with Kotlin for Android. This app allows you to create, save, and manage your notes effortlessly. Below, you'll find details about the app, its features, and what I learned while developing it.

---

## Screenshots

Here are some screenshots of the app in action:

![Screenshot 1](https://github.com/Felix-Red/Note_To_Self/blob/master/NoteToSelfPicture.png)  


---

## About the App

**Note to Self** is a beginner-friendly app designed to help users quickly jot down and organize their thoughts. The app uses modern Android development practices and leverages Kotlin's concise and expressive syntax.

### Key Features:
- **Add Notes**: Create new notes with a title and description.
- **Data Persistence**: Notes are saved locally on the device, so they persist even after the app is closed.

---

## What I Learned

While developing this app, I referred to the book **"Android Programming with Kotlin for Beginners" by John Horton**. This book provided a solid foundation for understanding Android development with Kotlin. Here are some key concepts I implemented and learned about:

1. **Adapters and RecyclerView**:
   - Used `RecyclerView` to display the list of notes efficiently.
   - Created a custom adapter to bind note data to the `RecyclerView` items.

2. **ArrayList**:
   - Utilized `ArrayList` to store and manage the list of notes in memory.

3. **Data Persistence**:
   - Implemented local data storage using `SharedPreferences` to save and retrieve notes.

4. **Kotlin Basics**:
   - Gained a deeper understanding of Kotlin's syntax, including lambdas, null safety, and extension functions.

---

## Future Improvements

- Add support for categorizing notes with tags or folders.
- Implement a search functionality to quickly find specific notes.
- Explore using a database like Room for more robust data management.

---


Feel free to explore the code, suggest improvements, or use it as a learning resource. Happy coding!
