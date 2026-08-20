fetch("/contacts")
    .then(response => {

        if (!response.ok) {
            throw new Error("Unable to load contacts");
        }

        return response.json();
    })

    .then(contacts => {

        const table =
            document.getElementById("contactTable");

        contacts.forEach(contact => {

            const row = document.createElement("tr");

            row.innerHTML = `
                <td>${contact.id}</td>
                <td>${contact.name}</td>
                <td>${contact.email}</td>
                <td>${contact.phone}</td>
                <td>${contact.message}</td>
            `;

            table.appendChild(row);
        });
    })

    .catch(error => {

        console.error(error);

        document.getElementById("contactTable")
            .innerHTML =
            `<tr>
                <td colspan="5">
                    Unable to load contacts
                </td>
             </tr>`;
    });