'use strict';

const output = document.getElementById("output");

const getCars = async () => {
    const res = await axios.get("/cars/");
    output.innerHTML = "";
    res.data.forEach(car => renderCar(car));
}

const renderCar = ({ id, make, model, colour, category }) => {
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

    const categoryText = document.createElement("p");
    categoryText.className = "card-text";
    categoryText.innerText = `Category: ${category}`;
    cardBody.appendChild(categoryText);

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

const CatsOutput = document.getElementById("CatsOutput");

const getCategory = async () => {
    const res = await axios.get("/category/");
    CatsOutput.innerHTML = "";
    res.data.forEach(cat => renderCategory(cat));
}

const renderCategory = ({ id, name }) => {
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
    makeText.innerText = `Category Name: ${name}`;
    cardBody.appendChild(makeText);

    const cardFooter = document.createElement("div");
    cardFooter.className = "card-footer";
    card.appendChild(cardFooter);


    const editCatButton = document.createElement("a");
    editCatButton.innerText = "Edit";
    editCatButton.className = "card-link";
    editCatButton.addEventListener("click", function () {
        updateCategory(id);

    });
    cardFooter.appendChild(editCatButton);

    CatsOutput.appendChild(column);

    const deleteButton = document.createElement("a");
    deleteButton.innerText = "Delete";
    deleteButton.className = "card-link";
    deleteButton.addEventListener("click", function () {
        deleteCategory(id);
    });
    cardFooter.appendChild(deleteButton);

    CatsOutput.appendChild(column);
}


getCars();

document.getElementById("createForm").addEventListener("submit", function (event) {
    event.preventDefault();

    const data = {
        make: this.make.value,
        model: this.Model.value,
        colour: this.Colour.value,
        category: this.id.value
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


getCategory();

document.getElementById("createCategoryForm").addEventListener("submit", function (event) {
    event.preventDefault();

    const data = {
        name: this.name.value

    };

    axios.post("/category/create", data)
        .then(res => {
            getCategory();
            this.reset();
            this.name.focus();
        }).catch(err => console.log(err));

    console.log(this);


    axios.put("/category/update", data)
        .then(resCat => {
            getCategory();
            this.reset();
        }).catch(err => console.log(err));

    console.log(this);


});


const deleteCategory = async (id) => {
    const res = await axios.delete(`/category/remove/${id}`);
    getCategory();
};