const Dev = require("../models/Dev");
const Parser = require("../utils/ParseToArray");

module.exports = {
  async index(req, res) {
    //BUscar

    const { latitude, longitude, techs } = req.query;

    const techsArray = Parser(techs);

    const devs = await Dev.find({
      techs: {
        $in: techsArray
      },
      location: {
        $near: {
          $geometry: {
            type: "Point",
            coordinates: [longitude, latitude]
          },
          $maxDistance: 10000
        }
      }
    });

    return res.json(devs);
  }
};
