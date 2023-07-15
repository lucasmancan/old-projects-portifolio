const axios = require("axios");
const Dev = require("../models/Dev");
const Parser = require("../utils/ParseToArray");

module.exports = {
  async index(req, res) {
    const devs = await Dev.find();

    return res.json(devs);
  },

  async store(req, res) {
    try {
      const { github_username, techs, latitude, longitude } = req.body;

      let dev = await Dev.findOne({ github_username });

      if (dev) {
        return res.json({ message: "Dev already exists!" });
      }

      const location = { type: "Point", coordinates: [latitude, longitude] };

      const techsArray = Parser(techs);

      const response = await axios.get(
        `https://api.github.com/users/${github_username}`
      );

      const { name = login, avatar_url, bio } = response.data;

      dev = await Dev.create({
        github_username,
        name,
        avatar_url,
        bio,
        techs: techsArray,
        location
      });

      return res.json(dev);
    } catch (e) {
      console.error(e);
      return res.json({ message: "GitHub username was not found!" });
    }
  }
};
