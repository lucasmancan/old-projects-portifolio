module.exports = function parseToArray(string) {
  return string.split(",").map(string => string.trim());
};
