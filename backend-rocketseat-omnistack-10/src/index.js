const express = require("express");
const mongoose = require("mongoose");
const app = express();
const config = require("./config");
const routes = require("./routes");

app.use(express.json());
app.use(routes);


// Replace with your connection string
mongoose.connect(config.connectionString);

app.get("/", (req, res) => {
  console.log(req.query);
  res.json({ message: "Hello World!" });
});

app.listen(3333);
