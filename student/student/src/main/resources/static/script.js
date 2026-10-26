loadStudents();


// ===============================
// Get all students
// ===============================
function loadStudents() {

    fetch("/students")
        .then(response => response.json())
        .then(students => {

            let table = document.getElementById("studentTable");

            table.innerHTML = "";

            students.forEach(student => {

                table.innerHTML += `
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.email}</td>
                        <td>${student.ph_no}</td>
                        <td>${student.age}</td>
                        <td>${student.gender}</td>
                        <td>${student.course}</td>

                        <td>
                            <button
                                class="btn btn-warning btn-sm"
                                onclick="editStudent(${student.id})">
                                Edit
                            </button>

                            <button
                                class="btn btn-danger btn-sm"
                                onclick="deleteStudent(${student.id})">
                                Delete
                            </button>
                        </td>
                    </tr>
                `;

            });

        })
        .catch(error => {

            console.error("Error:", error);

        });

}


// ===============================
// Add / Update student
// ===============================
document.getElementById("studentForm")
    .addEventListener("submit", function(event) {

        event.preventDefault();

        let form = document.getElementById("studentForm");

        // Get student ID
        let studentId = form.dataset.id;


        // Create student object
        let student = {

            name: document.getElementById("name").value,

            email: document.getElementById("email").value,

            ph_no: document.getElementById("ph_no").value,

            age: parseInt(
                document.getElementById("age").value
            ),

            gender: document.getElementById("gender").value,

            course: document.getElementById("course").value

        };


        // ===============================
        // UPDATE STUDENT
        // ===============================

        if (studentId) {

            fetch(`/students/${studentId}`, {

                method: "PUT",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify(student)

            })

            .then(response => {

                if (!response.ok) {
                    throw new Error("Update failed");
                }

                return response.json();

            })

            .then(result => {

                alert("Student updated successfully!");

                // Clear form
                form.reset();

                // Remove stored ID
                delete form.dataset.id;

                // Change button to Add Student
                let button = form.querySelector(
                    "button[type='submit']"
                );

                button.innerText = "Add Student";

                button.classList.remove("btn-success");

                button.classList.add("btn-primary");

                // Refresh table
                loadStudents();

            })

            .catch(error => {

                console.error("Error:", error);

                alert("Unable to update student!");

            });

        }


        // ===============================
        // ADD STUDENT
        // ===============================

        else {

            fetch("/students", {

                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify(student)

            })

            .then(response => response.json())

            .then(result => {

                alert("Student added successfully!");

                // Clear form
                form.reset();

                // Refresh table
                loadStudents();

            })

            .catch(error => {

                console.error("Error:", error);

                alert("Something went wrong!");

            });

        }

    });


// ===============================
// Edit student
// ===============================
function editStudent(id) {

    fetch(`/students/${id}`)
        .then(response => {

            if (!response.ok) {
                throw new Error("Student not found");
            }

            return response.json();

        })

        .then(student => {

            // Fill form
            document.getElementById("name").value = student.name;

            document.getElementById("email").value = student.email;

            document.getElementById("ph_no").value = student.ph_no;

            document.getElementById("age").value = student.age;

            document.getElementById("gender").value = student.gender;

            document.getElementById("course").value = student.course;


            // Store student ID
            document.getElementById("studentForm").dataset.id = student.id;


            // Change button
            let button = document.querySelector(
                "#studentForm button[type='submit']"
            );

            button.innerText = "Update Student";

            button.classList.remove("btn-primary");

            button.classList.add("btn-success");

        })

        .catch(error => {

            console.error("Error:", error);

            alert("Unable to load student!");

        });

}


// ===============================
// Delete student
// ===============================
function deleteStudent(id) {

    if (!confirm("Are you sure you want to delete this student?")) {
        return;
    }


    fetch(`/students/${id}`, {

        method: "DELETE"

    })

    .then(response => {

        if (!response.ok) {
            throw new Error("Delete failed");
        }

        return response.text();

    })

    .then(result => {

        alert("Student deleted successfully!");

        // Refresh table
        loadStudents();

    })

    .catch(error => {

        console.error("Error:", error);

        alert("Unable to delete student!");

    });

}