package com.semkagtn.javascriptic.compiler.visitor;

import com.semkagtn.javascriptic.compiler.tree.*;
import com.semkagtn.javascriptic.runtime.JSObject;

/**
 * Created by semkagtn on 19.05.15.
 */
public class ConstantFolder implements AstVisitor<AstNode> {

    private static ConstantNode toConstantNode(JSObject jsObject) {
        ConstantNode constantNode;
        switch (jsObject.getType()) {
            case BOOL:
                constantNode = new BoolNode();
                break;
            case NUMBER:
                constantNode = new NumberNode();
                break;
            case STRING:
                constantNode = new StringNode();
                break;
            case UNDEF:
                constantNode = new UndefNode();
                break;
            default:
                throw new RuntimeException();
        }
        constantNode.setValue(jsObject.getValue());
        return constantNode;
    }

    private static boolean isConstant(ExpressionNode... expressionNodes) {
        for (ExpressionNode expressionNode : expressionNodes) {
            if (!(expressionNode instanceof ConstantNode)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public AstNode visit(AddNode add) {
        add.setLhs((ExpressionNode) add.getLhs().accept(this));
        add.setRhs((ExpressionNode) add.getRhs().accept(this));
        if (isConstant(add.getLhs(), add.getRhs())) {
            JSObject lhs = ((ConstantNode) add.getLhs()).toJSObject();
            JSObject rhs = ((ConstantNode) add.getRhs()).toJSObject();
            return toConstantNode(lhs.add(rhs));
        }
        return add;
    }

    @Override
    public AstNode visit(AndNode and) {
        and.setLhs((ExpressionNode) and.getLhs().accept(this));
        and.setRhs((ExpressionNode) and.getRhs().accept(this));
        if (isConstant(and.getLhs(), and.getRhs())) {
            JSObject lhs = ((ConstantNode) and.getLhs()).toJSObject();
            JSObject rhs = ((ConstantNode) and.getRhs()).toJSObject();
            return toConstantNode(lhs.and(rhs));
        }
        return and;
    }

    @Override
    public AstNode visit(ArrayNode array) {
        for (ExpressionNode expression : array.getElements()) {
            expression.accept(this);
        }
        return array;
    }

    @Override
    public AstNode visit(AssignmentNode assign) {
        if (assign.getExpression() != null) {
            assign.setExpression((ExpressionNode) assign.getExpression().accept(this));
        }
        return assign;
    }

    @Override
    public AstNode visit(BlockNode block) {
        for (StatementNode statementNode : block.getBody()) {
            statementNode.accept(this);
        }
        return block;
    }

    @Override
    public AstNode visit(BoolNode bool) {
        return bool;
    }

    @Override
    public AstNode visit(DivNode div) {
        div.setLhs((ExpressionNode) div.getLhs().accept(this));
        div.setRhs((ExpressionNode) div.getRhs().accept(this));
        if (isConstant(div.getLhs(), div.getRhs())) {
            JSObject lhs = ((ConstantNode) div.getLhs()).toJSObject();
            JSObject rhs = ((ConstantNode) div.getRhs()).toJSObject();
            return toConstantNode(lhs.div(rhs));
        }
        return div;
    }

    @Override
    public AstNode visit(EqNode eq) {
        eq.setLhs((ExpressionNode) eq.getLhs().accept(this));
        eq.setRhs((ExpressionNode) eq.getRhs().accept(this));
        if (isConstant(eq.getLhs(), eq.getRhs())) {
            JSObject lhs = ((ConstantNode) eq.getLhs()).toJSObject();
            JSObject rhs = ((ConstantNode) eq.getRhs()).toJSObject();
            return toConstantNode(lhs.eq(rhs));
        }
        return eq;
    }

    @Override
    public AstNode visit(ExpressionStatementNode exprStat) {
        exprStat.setExpression((ExpressionNode) exprStat.getExpression().accept(this));
        return exprStat;
    }

    @Override
    public AstNode visit(FunctionCallNode functionCall) {
        functionCall.setFunction((ExpressionNode) functionCall.getFunction().accept(this));
        for (ExpressionNode argument : functionCall.getArguments()) {
            argument.accept(this);
        }
        return functionCall;
    }

    @Override
    public AstNode visit(FunctionNode function) {
        for (FunctionParameterNode parameter : function.getParameters()) {
            parameter.accept(this);
        }
        for (StatementNode statement : function.getBody()) {
            statement.accept(this);
        }
        return function;
    }

    @Override
    public AstNode visit(FunctionParameterNode functionParam) {
        return functionParam;
    }

    @Override
    public AstNode visit(GetFieldNode getIndex) {
        getIndex.setIndex((ExpressionNode) getIndex.getIndex().accept(this));
        getIndex.setVariable((ExpressionNode) getIndex.getVariable().accept(this));
        return getIndex;
    }

    @Override
    public AstNode visit(GeNode ge) {
        ge.setLhs((ExpressionNode) ge.getLhs().accept(this));
        ge.setRhs((ExpressionNode) ge.getRhs().accept(this));
        if (isConstant(ge.getLhs(), ge.getRhs())) {
            JSObject lhs = ((ConstantNode) ge.getLhs()).toJSObject();
            JSObject rhs = ((ConstantNode) ge.getRhs()).toJSObject();
            return toConstantNode(lhs.ge(rhs));
        }
        return ge;
    }

    @Override
    public AstNode visit(GtNode gt) {
        gt.setLhs((ExpressionNode) gt.getLhs().accept(this));
        gt.setRhs((ExpressionNode) gt.getRhs().accept(this));
        if (isConstant(gt.getLhs(), gt.getRhs())) {
            JSObject lhs = ((ConstantNode) gt.getLhs()).toJSObject();
            JSObject rhs = ((ConstantNode) gt.getRhs()).toJSObject();
            return toConstantNode(lhs.gt(rhs));
        }
        return gt;
    }

    @Override
    public AstNode visit(IfElseNode ifElse) {
        ifElse.setCondition((ExpressionNode) ifElse.getCondition().accept(this));
        ifElse.setIfStatement((StatementNode) ifElse.getIfStatement().accept(this));
        if (ifElse.getElseStatement() != null) {
            ifElse.setElseStatement((StatementNode) ifElse.getElseStatement().accept(this));
        }
        return ifElse;
    }

    @Override
    public AstNode visit(LeNode le) {
        le.setLhs((ExpressionNode) le.getLhs().accept(this));
        le.setRhs((ExpressionNode) le.getRhs().accept(this));
        if (isConstant(le.getLhs(), le.getRhs())) {
            JSObject lhs = ((ConstantNode) le.getLhs()).toJSObject();
            JSObject rhs = ((ConstantNode) le.getRhs()).toJSObject();
            return toConstantNode(lhs.le(rhs));
        }
        return le;
    }

    @Override
    public AstNode visit(LtNode lt) {
        lt.setLhs((ExpressionNode) lt.getLhs().accept(this));
        lt.setRhs((ExpressionNode) lt.getRhs().accept(this));
        if (isConstant(lt.getLhs(), lt.getRhs())) {
            JSObject lhs = ((ConstantNode) lt.getLhs()).toJSObject();
            JSObject rhs = ((ConstantNode) lt.getRhs()).toJSObject();
            return toConstantNode(lhs.lt(rhs));
        }
        return lt;
    }

    @Override
    public AstNode visit(ModNode mod) {
        mod.setLhs((ExpressionNode) mod.getLhs().accept(this));
        mod.setRhs((ExpressionNode) mod.getRhs().accept(this));
        if (isConstant(mod.getLhs(), mod.getRhs())) {
            JSObject lhs = ((ConstantNode) mod.getLhs()).toJSObject();
            JSObject rhs = ((ConstantNode) mod.getRhs()).toJSObject();
            return toConstantNode(lhs.mod(rhs));
        }
        return mod;
    }

    @Override
    public AstNode visit(MulNode mul) {
        mul.setLhs((ExpressionNode) mul.getLhs().accept(this));
        mul.setRhs((ExpressionNode) mul.getRhs().accept(this));
        if (isConstant(mul.getLhs(), mul.getRhs())) {
            JSObject lhs = ((ConstantNode) mul.getLhs()).toJSObject();
            JSObject rhs = ((ConstantNode) mul.getRhs()).toJSObject();
            return toConstantNode(lhs.mul(rhs));
        }
        return mul;
    }

    @Override
    public AstNode visit(NegNode neg) {
        neg.setExpression((ExpressionNode) neg.getExpression().accept(this));
        if (isConstant(neg.getExpression())) {
            JSObject expr = ((ConstantNode) neg.getExpression()).toJSObject();
            return toConstantNode(expr.neg());
        }
        return neg;
    }

    @Override
    public AstNode visit(NeNode ne) {
        ne.setLhs((ExpressionNode) ne.getLhs().accept(this));
        ne.setRhs((ExpressionNode) ne.getRhs().accept(this));
        if (isConstant(ne.getLhs(), ne.getRhs())) {
            JSObject lhs = ((ConstantNode) ne.getLhs()).toJSObject();
            JSObject rhs = ((ConstantNode) ne.getRhs()).toJSObject();
            return toConstantNode(lhs.ne(rhs));
        }
        return ne;
    }

    @Override
    public AstNode visit(NotNode not) {
        not.setExpression((ExpressionNode) not.getExpression().accept(this));
        if (isConstant(not.getExpression())) {
            JSObject expr = ((ConstantNode) not.getExpression()).toJSObject();
            return toConstantNode(expr.not());
        }
        return not;
    }

    @Override
    public AstNode visit(NumberNode number) {
        return number;
    }

    @Override
    public AstNode visit(OrNode or) {
        or.setLhs((ExpressionNode) or.getLhs().accept(this));
        or.setRhs((ExpressionNode) or.getRhs().accept(this));
        if (isConstant(or.getLhs(), or.getRhs())) {
            JSObject lhs = ((ConstantNode) or.getLhs()).toJSObject();
            JSObject rhs = ((ConstantNode) or.getRhs()).toJSObject();
            return toConstantNode(lhs.or(rhs));
        }
        return or;
    }

    @Override
    public AstNode visit(PlusNode plus) {
        plus.setExpression((ExpressionNode) plus.getExpression().accept(this));
        if (isConstant(plus.getExpression())) {
            JSObject expr = ((ConstantNode) plus.getExpression()).toJSObject();
            return toConstantNode(expr.plus());
        }
        return plus;
    }

    @Override
    public AstNode visit(ProgramNode program) {
        for (StatementNode statementNode : program.getBody()) {
            statementNode.accept(this);
        }
        return program;
    }

    @Override
    public AstNode visit(PutFieldNode putIndex) {
        putIndex.setExpression((ExpressionNode) putIndex.getExpression().accept(this));
        putIndex.setIndex((ExpressionNode) putIndex.getIndex().accept(this));
        putIndex.setVariable((ExpressionNode) putIndex.getVariable().accept(this));
        return putIndex;
    }

    @Override
    public AstNode visit(ReturnNode returnStat) {
        returnStat.setValue((ExpressionNode) returnStat.getValue().accept(this));
        return returnStat;
    }

    @Override
    public AstNode visit(StrictEqNode eq) {
        eq.setLhs((ExpressionNode) eq.getLhs().accept(this));
        eq.setRhs((ExpressionNode) eq.getRhs().accept(this));
        if (isConstant(eq.getLhs(), eq.getRhs())) {
            JSObject lhs = ((ConstantNode) eq.getLhs()).toJSObject();
            JSObject rhs = ((ConstantNode) eq.getRhs()).toJSObject();
            return toConstantNode(lhs.strictEq(rhs));
        }
        return eq;
    }

    @Override
    public AstNode visit(StrictNeNode ne) {
        ne.setLhs((ExpressionNode) ne.getLhs().accept(this));
        ne.setRhs((ExpressionNode) ne.getRhs().accept(this));
        if (isConstant(ne.getLhs(), ne.getRhs())) {
            JSObject lhs = ((ConstantNode) ne.getLhs()).toJSObject();
            JSObject rhs = ((ConstantNode) ne.getRhs()).toJSObject();
            return toConstantNode(lhs.strictNe(rhs));
        }
        return ne;
    }

    @Override
    public AstNode visit(StringNode string) {
        return string;
    }

    @Override
    public AstNode visit(SubNode sub) {
        sub.setLhs((ExpressionNode) sub.getLhs().accept(this));
        sub.setRhs((ExpressionNode) sub.getRhs().accept(this));
        if (isConstant(sub.getLhs(), sub.getRhs())) {
            JSObject lhs = ((ConstantNode) sub.getLhs()).toJSObject();
            JSObject rhs = ((ConstantNode) sub.getRhs()).toJSObject();
            return toConstantNode(lhs.sub(rhs));
        }
        return sub;
    }

    @Override
    public AstNode visit(UndefNode undef) {
        return undef;
    }

    @Override
    public AstNode visit(VarNode var) {
        return var;
    }

    @Override
    public AstNode visit(WhileNode whileStat) {
        whileStat.setCondition((ExpressionNode) whileStat.getCondition().accept(this));
        whileStat.setStatement((StatementNode) whileStat.getStatement().accept(this));
        return whileStat;
    }

    @Override
    public AstNode visit(DoWhileNode doWhile) {
        doWhile.setCondition((ExpressionNode) doWhile.getCondition().accept(this));
        doWhile.setStatement((StatementNode) doWhile.getStatement().accept(this));
        return doWhile;
    }
}
