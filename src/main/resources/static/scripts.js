'use strict';

const output = document.getElementById("output");

const getCars = async () => {
    const res = await axios.get("/cars/");
    output.innerHTML = "";
    res.data.forEach(car => renderCar(car));
}

const renderCar = ({ id, make, model, colour }) => {
    const column = document.createElement("div");
    column.className = "col";

    const card = document.createElement("div");
    card.className = "card";
    column.appendChild(card);

    const cardBody = document.createElement("div");
    cardBody.className = "card-body";
    card.appendChild(cardBody);

    const makeText = document.createElement("p");
    makeText.className = "card-text";
    makeText.innerText = `Make: ${make}`;
    cardBody.appendChild(makeText);

    const modelText = document.createElement("p");
    modelText.className = "card-text";
    modelText.innerText = `Model: ${model}`;
    cardBody.appendChild(modelText);

    const colourText = document.createElement("p");
    colourText.className = "card-text";
    colourText.innerText = `Colour: ${colour}`;
    cardBody.appendChild(colourText);

    const catalogText = document.createElement("p");
    catalogText.className = "card-text";
    catalogText.innerText = `Category: ${category}`;
    cardBody.appendChild(catalogText);

    const cardFooter = document.createElement("div");
    cardFooter.className = "card-footer";
    card.appendChild(cardFooter);


    const editButton = document.createElement("a");
    editButton.innerText = "Edit";
    editButton.className = "card-link";
    editButton.addEventListener("click", function () {
        updateCar(id);

    });
    cardFooter.appendChild(editButton);

    output.appendChild(column);

    const deleteButton = document.createElement("a");
    deleteButton.innerText = "Delete";
    deleteButton.className = "card-link";
    deleteButton.addEventListener("click", function () {
        deleteCar(id);
    });
    cardFooter.appendChild(deleteButton);

    output.appendChild(column);
}

getCars();

document.getElementById("createForm").addEventListener("submit", function (event) {
    event.preventDefault();

    const data = {
        make: this.make.value,
        model: this.Model.value,
        colour: this.Colour.value,

    };

    axios.post("/cars/create", data)
        .then(res => {
            getCars();
            this.reset();
            this.make.focus();
        }).catch(err => console.log(err));

    console.log(this);
});

const deleteCar = async (id) => {
    const res = await axios.delete(`/cars/remove/${id}`);
    getCars();
};