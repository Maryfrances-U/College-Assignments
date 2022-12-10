CC ?= gcc
CFLAGS := -std=c99 -Wall -Werror

BIN := database
SRCDIR := src
BLDDIR := build
SRCS := $(shell find $(SRCDIR) -name '*.c')
OBJS := $(addprefix $(BLDDIR)/,$(SRCS:%.c=%.o))

# === Recipes ===
.DEFAULT_GOAL := $(BLDDIR)/$(BIN)

$(BLDDIR)/$(BIN): $(OBJS)
	$(CC) $(CFLAGS) -o $@ $(OBJS)
	@cp $(BLDDIR)/$(BIN) $(BIN)

$(BLDDIR)/%.o: %.c $(BLDDIR)/$(SRCDIR)
	$(CC) $(CFLAGS) -o $@ -c $<

$(BLDDIR)/$(SRCDIR):
	@mkdir -p $(BLDDIR)/$(SRCDIR)

