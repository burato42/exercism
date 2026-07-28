pub fn reply(message: &str) -> &str {
    match message {
        s if s.trim() == "" => "Fine. Be that way!",
        s if s == s.to_uppercase() && s.ends_with('?') && s.chars().any(|c| c.is_uppercase()) => {
            "Calm down, I know what I'm doing!"
        }
        s if s.trim().ends_with('?') => "Sure.",
        s if s == s.to_uppercase() && s.chars().any(|c| c.is_uppercase()) => "Whoa, chill out!",
        _ => "Whatever.",
    }
}
